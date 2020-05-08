package ru.gavryushkin.parser.rest;


import com.google.gson.Gson;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import ru.gavryushkin.parser.LineChart1;
import ru.gavryushkin.parser.ParserApplication;
import ru.gavryushkin.parser.model.Equity;
import ru.gavryushkin.parser.model.OrderWebHook;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class JettyApplication {
    static Server server = new Server();
    private static String orderSide = "";
    private static ParserApplication.Trade trade;
    private static ParserApplication.Dialog dialog;
    private static ParserApplication.WebHooksModule webHooksModule;
    static ServletContextHandler context;
    static String HOST = "";

    public JettyApplication(ParserApplication.Trade trade, ParserApplication.Dialog dialog, ParserApplication.WebHooksModule webHooksModule) {
        this.trade = trade;
        this.dialog = dialog;
        this.webHooksModule = webHooksModule;
    }

    public void startServerJetty() {
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(80);
        server.addConnector(connector);
        context = new ServletContextHandler();
        context.setContextPath("/");
        context.addServlet(WebHookServlet.class, "/webHook");
        context.addServlet(CustomWebHookServlet.class, "/customWebHook");
        context.addServlet(RemoteServlet.class, "/remote");
        context.addServlet(ImageServlet.class, "/image");
        context.addServlet(BuyServlet.class, "/buy");
        context.addServlet(SellServlet.class, "/sell");
        context.addServlet(GetGraph.class, "/getGraph");
        context.addServlet(ActivateAuto.class, "/activateAuto");
        server.setHandler(context);
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("serial")
    public static class WebHookServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request,
                             HttpServletResponse response) throws IOException {
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            response.getWriter().println("<h1>Test Success</h1>");
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setStatus(HttpServletResponse.SC_OK);
            Scanner s = new Scanner(request.getInputStream());
            String data = "";
            while (s.hasNext()) {
                data += s.next();
            }
            s.close();
            write_file("server-log.txt", data);
            Map map = new Gson().fromJson(data, Map.class);
            orderSide = (String) map.get("orderSide");
            if (orderSide.equals("Buy")) {
                trade.sendSignalWebHook(1);
            } else if (orderSide.equals("Sell")) {
                trade.sendSignalWebHook(-1);
            } else if (orderSide.equals("Hold")) {
                trade.sendSignalWebHook(0);
            }
        }
    }

    public String getOrderSide() {
        return orderSide;
    }

    public void setOrderSide(String orderSide) {
        orderSide = orderSide;
    }

    public static class RemoteServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            try {
                createScreenformail();
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.setCharacterEncoding("utf-8");
                resp.getWriter().println("<html>");
                resp.getWriter().println("<head>");
                resp.getWriter().println("<title>Desktop View</title>");
                resp.getWriter().println("</head>");
                resp.getWriter().println("<body>");
                resp.getWriter().println("<h1 style=\"color:blue;border-bottom: 2px solid maroon;\">DESKTOP VIEW</h1>");
                resp.getWriter().println("<img style=\"width:700px;height:500px;margin-bottom:20px\" src=\"/image\">");
                resp.getWriter().println("<form action=\"/r\"\"/example/\">\n" +
                        "<button style=\"color:white;width:2px;height:2px;background:blue;font-size:30px;display: none\" type=\"submit\">REFRESH</button>\n" +
                        "</form>");
                resp.getWriter().println("<form action=\"/remote\"\"/example/\">\n" +
                        "<button style=\"color:white;width:150px;height:50px;background:blue;font-size:30px;\" type=\"submit\">REFRESH</button>\n" +
                        "</form>");
                resp.getWriter().println("<form action=\"/buy\"\"/example/\">\n" +
                        "<button style=\"color:white;width:100px;height:50px;background:green;font-size:30px;\" type=\"submit\">BUY</button>\n" +
                        "</form>");
                resp.getWriter().println("<form action=\"/sell\"\"/example/\">\n" +
                        "<button style=\"color:white;width:100px;height:50px;background:red;font-size:30px;\" type=\"submit\">SELL</button>\n" +
                        "</form>");
                resp.getWriter().println("<div id=\"chartContainer\" style=\"height: 300px; width: 700px;border: solid 2px #010522;\"></div>\n" +
                        "\n" +
                        "<script src=\"https://canvasjs.com/assets/script/canvasjs.min.js\"></script>\n" +
                        "<script type=\"text/javascript\">\n" +
                        "    var form = document.getElementsByTagName('form')[0];\n" +
                        "    var arr;\n" +
                        "    var mas=[{x: 1, y: 2},\n" +
                        "        {x: 5, y: 10 }];\n" +
                        "\n" +
                        "    form.addEventListener('submit', function (event) {\n" +
                        "        event.preventDefault();\n" +
                        "        var row = JSON.stringify({\n" +
                        "            \"stocks\": this.stocks.value,\n" +
                        "            \"drawdownLevel\": this.drawdownLevel.value,\n" +
                        "            \"duration\": this.duration.value,\n" +
                        "            \"startDate\": this.startDate.value,\n" +
                        "            \"profit\": this.profit.value,\n" +
                        "            \"comment\": this.comment.value\n" +
                        "        });\n" +
                        "        console.log(row);\n" +
                        "        $.ajax({\n" +
                        "            url: '/handler',\n" +
                        "            datatype: 'json',\n" +
                        "            type: \"post\",\n" +
                        "            contentType: \"application/json\",\n" +
                        "            data: row,\n" +
                        "            success: function (data) {\n" +
                        "                mas=data;\n" +
                        "                console.log(data);\n" +
                        "                // $(\"#paragraph\").text(JSON.parse(data));\n" +
                        "            }\n" +
                        "        });\n" +
                        "    });\n" +
                        "\n" +
                        "    window.onload =  async function () {\n" +
                        "        let response = await fetch('/getGraph', {\n" +
                        "            method: 'GET'\n" +
                        "        });\n" +
                        "\n" +
                        "        var chart = new CanvasJS.Chart(\"chartContainer\", {\n" +
                        "            animationEnabled: false,\n" +
                        "            theme: \"dark2\",\n" +
                        "            title: {\n" +
                        "                text: \"Equity\"\n" +
                        "            },\n" +
                        "            axisX: {\n" +
                        "                title: \"Order Number\",\n" +
                        "                crosshair: {\n" +
                        "                    enabled: true,\n" +
                        "                    snapToDataPoint: true\n" +
                        "                }\n" +
                        "            },\n" +
                        "            axisY: {\n" +
                        "                title: \"Profit in points\",\n" +
                        "                includeZero: false,\n" +
                        "                crosshair: {\n" +
                        "                    enabled: true,\n" +
                        "                    snapToDataPoint: true\n" +
                        "                }\n" +
                        "            },\n" +
                        "            data: [{\n" +
                        "                type: \"area\",\n" +
                        "                dataPoints: await response.json()\n" +
                        "            }]\n" +
                        "        });\n" +
                        "        chart.render();\n" +
                        "\n" +
                        "    }\n" +
                        "</script>");
                resp.getWriter().println("</body>");
                resp.getWriter().println("</html>");
            } catch (Exception e) {
                resp.getWriter().println("Not found!");
            }
        }
    }

    public static class ImageServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("image/jpg");
            BufferedImage img = ImageIO.read(new File("screen.jpg"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", baos);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            baos.close();
            OutputStream out = resp.getOutputStream();
            out.write(imageInByte);
            out.flush();
            out.close();
        }
    }

    //Метод:делаем скан и направляем на почту
    private static void createScreenformail() {
        Robot robot = null;
        try {
            robot = new Robot();
            BufferedImage screen = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(screen, "JPG", new File("screen.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Сервлет покупки
    public static class BuyServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setStatus(HttpServletResponse.SC_OK);
            trade.Order_B();
            req.getRequestDispatcher("/remote").forward(req, resp);
        }
    }

    //Сервлет продажи
    public static class SellServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setStatus(HttpServletResponse.SC_OK);
            trade.Order_S();
            req.getRequestDispatcher("/remote").forward(req, resp);
        }
    }

    //Сервлет графика
    public static class GetGraph extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("application/json");
            Equity eq = new Equity();
            eq.setList(LineChart1.getList());
            Gson gson = new Gson();
            OutputStream out = resp.getOutputStream();
            out.write(gson.toJson(eq.getList()).getBytes());
            out.flush();
            out.close();
        }
    }


    //Запись текста в файл
    static void write_file(String path, String content) {
        BufferedWriter wr = null;
        try {
            wr = new BufferedWriter(new FileWriter(path, true));
            wr.write(new Date() + " " + content);
            wr.write("\n");
            wr.flush();
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Активация автоматической торговли
    private class ActivateAuto extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            trade.setStatus(0);
            dialog.getBoxtrade().setState(true);
            dialog.save();
        }
    }

    //Текущий статус сервера
    public static boolean getStatusServer() {
        return server.isStarted();
    }

    @SuppressWarnings("serial")
    public static class CustomWebHookServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request,
                             HttpServletResponse response) throws IOException {
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            response.getWriter().println("<h1>Test Success Custom WebHook</h1>");
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setStatus(HttpServletResponse.SC_OK);
            Scanner s = new Scanner(request.getInputStream());
            String data = "";
            while (s.hasNext()) {
                data += s.next();
            }
            s.close();
            write_file("server-log.txt", data);
            OrderWebHook orderWebHook=null;
            try {
                orderWebHook = new Gson().fromJson(data, OrderWebHook.class);
            }catch (Exception e){
                e.printStackTrace();
            }
            orderSide = orderWebHook.getOperation();
            if (orderSide.equals("buy")) {
                webHooksModule.sendSignalWebHook(1, orderWebHook);
            } else if (orderSide.equals("sell")) {
                webHooksModule.sendSignalWebHook(-1, orderWebHook);
            } else if (orderSide.equals("hold")) {
                webHooksModule.sendSignalWebHook(0, orderWebHook);
            }
        }
    }
}
