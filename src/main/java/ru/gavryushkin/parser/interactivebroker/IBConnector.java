package ru.gavryushkin.parser.interactivebroker;

import apidemo.ContractInfoPanel;
import apidemo.TradesPanel;
import apidemo.util.IConnectionConfiguration;
import apidemo.util.NewTabbedPanel;
import apidemo.util.VerticalPanel;
import com.ib.client.Contract;
import com.ib.client.Order;
import com.ib.client.OrderState;
import com.ib.client.Types;
import com.ib.controller.ApiConnection;
import com.ib.controller.ApiController;
import com.ib.controller.Formats;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import ru.gavryushkin.parser.CustomWebHooksModule;
import ru.gavryushkin.parser.DesktopObject;
import ru.gavryushkin.parser.ParserApplication;
import ru.gavryushkin.parser.model.OrderWebHook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Коннектор для Interactive Brokers
 * 08.07.2020
 *
 * @author Gavryushkin S.I.
 */
public class IBConnector implements ApiController.IConnectionHandler {
    private final RestTemplate restTemplate = new RestTemplate();
    private final HttpHeaders headers = new HttpHeaders();
    private List<BigDecimal> completedOrders = new ArrayList<>();
    private TradesPanel tradesPanel;
    private static StringWriter wr = new StringWriter();
    private static ArrayList<BigDecimal> mapEq;
    private final JTextArea msg = new JTextArea();
    private final List<String> m_acctList = new ArrayList<>();
    private static IConnectionConfiguration connectionConfiguration;
    private final JTabbedPane tabbedPanel = new JTabbedPane();
    private static ConnectionPanel connectionPanel;
    private Thread connectThread;
    private volatile int orderId = 0;
    //Панели
    private final ContractInfoPanel contractInfoPanel;
    //
    private ApiController controller;
    private final JDialog dialog;
    private final JTextArea inLog = new JTextArea();
    private final JTextArea outLog = new JTextArea();
    private final Logger inLogger = new Logger(inLog);
    private final Logger outLogger = new Logger(outLog);
    private boolean statusThread = false;
    private JButton connect;
    private CustomWebHooksModule cwm;
    private BigDecimal big=new BigDecimal(-1);
    Color dark = new Color(2, 2, 2, 179);

    public IBConnector(IConnectionConfiguration connectionConfig, JFrame frame, CustomWebHooksModule cwm) {
        dialog = new JDialog(frame, "Interactive Broker");
        connectionConfiguration = connectionConfig;
        connectionPanel = new ConnectionPanel();
        contractInfoPanel = new ContractInfoPanel();
        tradesPanel = new TradesPanel();
        this.cwm = cwm;
//        for (Map.Entry<Integer, DesktopObject> entry : cwm.getMap().entrySet()) {
//            if ("IB".equals(entry.getValue().getType().getSelectedItem().toString())) {
//                statusThread = true;
//                connectionPanel.onConnect();
//            }
//        }
    }

    ApiConnection.ILogger getInLogger() {
        return inLogger;
    }

    ApiConnection.ILogger getOutLogger() {
        return outLogger;
    }

    public ApiController controller() {
        if (controller == null) {
            controller = new ApiController(this, getInLogger(), getOutLogger());
        }
        return controller;
    }

    public void start() {
        msg.setEditable(false);
        msg.setLineWrap(true);
        JScrollPane msgScroll = new JScrollPane(msg);
        msgScroll.setPreferredSize(new Dimension(300, 100));

        JScrollPane outLogScroll = new JScrollPane(outLog);
        outLogScroll.setPreferredSize(new Dimension(300, 100));

        JScrollPane inLogScroll = new JScrollPane(inLog);
        inLogScroll.setPreferredSize(new Dimension(300, 100));

        NewTabbedPanel bot = new NewTabbedPanel();
        bot.addTab("Messages", msgScroll);
        bot.addTab("Log (out)", outLogScroll);
        bot.addTab("Log (in)", inLogScroll);

        dialog.add(bot, BorderLayout.SOUTH);
        dialog.setSize(400, 700);
        tabbedPanel.addTab("Подключение", connectionPanel);
        tabbedPanel.addTab("Информация о контракте", contractInfoPanel);
        tabbedPanel.addTab("Сделки", tradesPanel);
        dialog.add(tabbedPanel);
        dialog.setBounds(800, 10, 400, 550);
    }

    private class ConnectionPanel extends JPanel {
        private final JTextField hostIb = new JTextField(connectionConfiguration.getDefaultHost(), 10);
        private final JTextField portIb = new JTextField(connectionConfiguration.getDefaultPort(), 10);
        private final JTextField clientIdIb = new JTextField("0", 10);
        private final JTextField connectOptions = new JTextField(connectionConfiguration.getDefaultConnectOptions(), 10);
        private final JLabel statusIB = new JLabel("Disconnected");
        private final JButton getOrder = new JButton();
        private final JLabel url = new JLabel("URL");
        private final JTextField urlText = new JTextField();
        private final JLabel name = new JLabel("NameTs");
        private final JTextField nameTxt = new JTextField();
        private final JButton buyBtn = new JButton("BUY");
        private final JButton sellBtn = new JButton("SELL");

        ConnectionPanel() {
            connect = new JButton("Connect");
            connect.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    statusThread = true;
                    onConnect();
                }
            });

            JButton disconnect = new JButton("Disconnect");
            disconnect.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    statusThread = false;
                    connect.setBackground(dark);
                    controller().disconnect();
                }
            });
            connect.setBackground(dark);
            connect.setForeground(Color.white);
            disconnect.setBackground(dark);
            disconnect.setForeground(Color.white);

            JLabel label = new JLabel("contractId");
            JTextField contractId = new JTextField();
            JLabel label1 = new JLabel("symbol");
            JTextField symbol = new JTextField();
            JLabel label2 = new JLabel("exchange");
            JTextField exchange = new JTextField();
            JLabel label3 = new JLabel("quantity");
            JTextField quantity = new JTextField();
            JLabel label4 = new JLabel("secType");
            JTextField secType = new JTextField();
            JLabel label5 = new JLabel("localSymbol");
            JTextField localSymbol = new JTextField();

            JButton buy = new JButton("Buy");
            JButton sell = new JButton(("Sell"));
            buy.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    createOrder(symbol.getText(), exchange.getText(), quantity.getText(), secType.getText(), localSymbol.getText(), contractId.getText(), true);
                }
            });
            sell.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    createOrder(symbol.getText(), exchange.getText(), quantity.getText(), secType.getText(), localSymbol.getText(), contractId.getText(), false);
                }
            });

            JPanel p1 = new VerticalPanel();
            p1.add("Host", hostIb);
            p1.add("Port", portIb);
            p1.add("Client ID", clientIdIb);
            p1.add(connect);
            p1.add(disconnect);
            p1.add("Connection status: ", statusIB);
            if (connectionConfiguration.getDefaultConnectOptions() != null) {
                p1.add("Connect options", connectOptions);
            }
            p1.add(url);
            p1.add(urlText);
            p1.add(name);
            p1.add(nameTxt);
            urlText.setText("http://188.120.250.228:80/customWebHook");
            p1.add(buyBtn);
            buyBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        headers.setContentType(MediaType.APPLICATION_JSON);
                        String body = "{\"nameTs\":\"" + nameTxt.getText() + "\",\"operation\":\"buy\"}";
                        HttpEntity<String> entity = new HttpEntity(body, headers);
                        restTemplate.exchange(
                                urlText.getText(), HttpMethod.POST, entity, Void.class);
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(dialog,"Ошибка вебхук");
                    }
                }
            });
            p1.add(sellBtn);
            sellBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        headers.setContentType(MediaType.APPLICATION_JSON);
                        String body = "{\"nameTs\":\"" + nameTxt.getText() + "\",\"operation\":\"sell\"}";
                        HttpEntity<String> entity = new HttpEntity(body, headers);
                        restTemplate.exchange(
                                urlText.getText(), HttpMethod.POST, entity, Void.class);
                    }catch (Exception ex){
                    JOptionPane.showMessageDialog(dialog,"Ошибка вебхук");
                }

                }
            });
            getOrder.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    controller.reqCompletedOrders(new ApiController.ICompletedOrdersHandler() {
                        @Override
                        public void completedOrder(Contract contract, Order order, OrderState orderState) {
                            completedOrders.clear();
                            CompletedOrder subOrder = new CompletedOrder(contract, order, orderState);
                            if (subOrder.m_orderState.status().equals("Filled")) {
                                if (subOrder.m_order.action() == Types.Action.BUY) {
                                    completedOrders.add(BigDecimal.valueOf(subOrder.m_order.auxPrice() * (-1)));
                                } else {
                                    completedOrders.add(BigDecimal.valueOf(subOrder.m_order.auxPrice()));
                                }
                            }
                        }

                        @Override
                        public void completedOrdersEnd() {

                        }
                    });
                }
            });
            //p1.add(getOrder);

            setLayout(new BorderLayout());
            add(p1, BorderLayout.NORTH);
        }

        public void onConnect() {
            int port = Integer.parseInt(portIb.getText());
            int clientId = Integer.parseInt(clientIdIb.getText());
            if (statusThread) {
                connectThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (statusThread) {
                            try {
                                if (!controller().client().isConnected()) {
                                    connectionPanel.statusIB.setText("disconnected");
                                    connect.setBackground(Color.red);
                                    IBConnector.this.show("Try connect");
                                    controller.connect(hostIb.getText(), port, clientId, connectOptions.getText());
                                }
                                Thread.sleep(1000);
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(new JFrame(), "Потеряно соединение с IB");
                            }
                        }
                    }
                });
                connectThread.start();
            }
        }
    }

    private static class Logger implements ApiConnection.ILogger {
        final private JTextArea m_area;

        Logger(JTextArea area) {
            m_area = area;
        }

        @Override
        public void log(final String str) {
            SwingUtilities.invokeLater(() -> {
//					m_area.append(str);
//
//					Dimension d = m_area.getSize();
//					m_area.scrollRectToVisible( new Rectangle( 0, d.height, 1, 1) );
            });
        }
    }

    @Override
    public void connected() {
        show("connected");
        connect.setBackground(Color.GREEN);
        connectionPanel.statusIB.setText("connected");
        controller().reqCurrentTime(time -> show("Server date/time is " + Formats.fmtDate(time * 1000)));

        controller().reqBulletins(true, (msgId, newsType, message, exchange) -> {
            String str = String.format("Received bulletin:  type=%s  exchange=%s", newsType, exchange);
            show(str);
            show(message);
        });
    }

    @Override
    public void disconnected() {
        show("disconnected");
        connect.setBackground(dark);
        connect.setForeground(Color.white);
        connectionPanel.statusIB.setText("disconnected");
    }

    @Override
    public void accountList(List<String> list) {
        show("Received account list");
        m_acctList.clear();
        m_acctList.addAll(list);
    }

    @Override
    public void show(final String str) {
        SwingUtilities.invokeLater(() -> {
            msg.append(str);
            msg.append("\n\n");

            Dimension d = msg.getSize();
            msg.scrollRectToVisible(new Rectangle(0, d.height, 1, 1));
        });
    }

    @Override
    public void error(Exception e) {
        show(e.toString());
    }

    @Override
    public void message(int id, int errorCode, String errorMsg) {
        show(id + " " + errorCode + " " + errorMsg);
    }

    /**
     * Отправка заявок на IB по сигналам вебхуков
     */
    public synchronized void openBuyOrder(ParserApplication.Dialog dialog, JTextField text, int status, DesktopObject obj, ParserApplication.Test test, OrderWebHook order) {
        try {
            if (order == null || order.getPosition() == null) {
                if (status == -1) {
                    if (obj.getTarget().getLabel()
                            .equals("All") || obj.getTarget().getLabel()
                            .equals("Quik")) {
                        if (obj.getjCheckBox().isSelected()) {
                            orderId = createOrder(
                                    obj.getSeccode().getText(),
                                    obj.getExchange().getText(),
                                    String.valueOf(Integer.parseInt(obj.getQuantity().getText()) * 2),
                                    obj.getSecType().getText().replace("secType", ""),
                                    obj.getLocalSymbol().getText().replace("localSymbol", ""),
                                    obj.getContractID().getText().replace("contractId", ""),
                                    true
                            );
                        }
                    }
                    if(order!=null) {
                        if(order.getPrice()!=null) {
                            mapEq = obj.getEq().getB();
                            mapEq.add(order.getPrice().multiply(big));
                            mapEq.add(order.getPrice().multiply(big));
                            obj.getEq().setB(mapEq);
                            obj.countLoss();
                            HashMap<Integer, DesktopObject> s = new HashMap<>();
                            s.put(obj.getIdObject(), obj);
                            cwm.save(s);
                        }
                    }
                } else if (status == 0) {
                    if (obj.getTarget().getLabel()
                            .equals("All") || obj.getTarget().getLabel()
                            .equals("Quik")) {
                        if (obj.getjCheckBox().isSelected()) {
                            orderId = createOrder(
                                obj.getSeccode().getText(),
                                obj.getExchange().getText(),
                                obj.getQuantity().getText(),
                                obj.getSecType().getText().replace("secType", ""),
                                obj.getLocalSymbol().getText().replace("localSymbol", ""),
                                obj.getContractID().getText().replace("contractId", ""),
                                true
                        );
                            }
                    }
                    if(order!=null) {
                        if(order.getPrice()!=null) {
                            mapEq = obj.getEq().getB();
                            mapEq.add(order.getPrice().multiply(big));
                            obj.getEq().setB(mapEq);
                            obj.countLoss();
                            HashMap<Integer, DesktopObject> s = new HashMap<>();
                            s.put(obj.getIdObject(), obj);
                            cwm.save(s);
                        }
                    }
                }
            } else {
                if (obj.getTarget().getLabel()
                        .equals("All") || obj.getTarget().getLabel()
                        .equals("Quik")) {
                        orderId = createOrder(
                            obj.getSeccode().getText(),
                            obj.getExchange().getText(),
                            String.valueOf(Integer.valueOf(order.getPosition()) - obj.getCurrentPosition()),
                            obj.getSecType().getText().replace("secType", ""),
                            obj.getLocalSymbol().getText().replace("localSymbol", ""),
                            obj.getContractID().getText().replace("contractId", ""),
                            true
                    );
                    obj.setCurrentPosition(Integer.parseInt(order.getPosition()));
                    HashMap<Integer, DesktopObject> s = new HashMap<>();
                    s.put(obj.getIdObject(), obj);
                    cwm.save(s);
                }
            }
//            if (obj.getTarget().getLabel()
//                    .equals("All") || obj.getTarget().getLabel()
//                    .equals("Mail")) {
//                test.sendSignal("BUY", "TS_1: Buy in signal at price " + obj.getSeccode().getText() + " " + " " + new Date());
//            }
        } catch (Exception e) {
            e.printStackTrace(new PrintWriter(wr));
            write_log("BUY", "orderlog.txt", wr.toString());
            wr.getBuffer().setLength(0);
        }
    }

    public synchronized void openSellOrder(ParserApplication.Dialog dialog, JTextField text, int status, DesktopObject obj, ParserApplication.Test test, OrderWebHook order) {
        try {
            if (order == null || order.getPosition() == null) {
                if (status == 1) {
                    if (obj.getTarget().getLabel()
                            .equals("All") || obj.getTarget().getLabel()
                            .equals("Quik")) {
                        if (obj.getjCheckBox().isSelected()) {
                            createOrder(
                                    obj.getSeccode().getText(),
                                    obj.getExchange().getText(),
                                    String.valueOf(Integer.parseInt(obj.getQuantity().getText()) * 2),
                                    obj.getSecType().getText().replace("secType", ""),
                                    obj.getLocalSymbol().getText().replace("localSymbol", ""),
                                    obj.getContractID().getText().replace("contractId", ""),
                                    false
                            );
                        }
                    }
                    if(order!=null) {
                        if(order.getPrice()!=null) {
                            mapEq = obj.getEq().getS();
                            mapEq.add(order.getPrice());
                            mapEq.add(order.getPrice());
                            obj.getEq().setS(mapEq);
                            obj.countLoss();
                            HashMap<Integer, DesktopObject> s = new HashMap<>();
                            s.put(obj.getIdObject(), obj);
                            cwm.save(s);
                        }
                    }
                } else if (status == 0) {
                    if (obj.getTarget().getLabel()
                            .equals("All") || obj.getTarget().getLabel()
                            .equals("Quik")) {
                        if (obj.getjCheckBox().isSelected()) {
                            createOrder(
                                    obj.getSeccode().getText(),
                                    obj.getExchange().getText(),
                                    obj.getQuantity().getText(),
                                    obj.getSecType().getText().replace("secType", ""),
                                    obj.getLocalSymbol().getText().replace("localSymbol", ""),
                                    obj.getContractID().getText().replace("contractId", ""),
                                    false
                            );
                        }
                    }
                    if(order!=null) {
                        if(order.getPrice()!=null) {
                            mapEq = obj.getEq().getB();
                            mapEq.add(order.getPrice());
                            obj.getEq().setB(mapEq);
                            obj.countLoss();
                            HashMap<Integer, DesktopObject> s = new HashMap<>();
                            s.put(obj.getIdObject(), obj);
                            cwm.save(s);
                        }
                    }
                }
            } else {
                if (obj.getTarget().getLabel()
                        .equals("All") || obj.getTarget().getLabel()
                        .equals("Quik")) {
                    if (obj.getjCheckBox().isSelected()) {
                        createOrder(
                                obj.getSeccode().getText(),
                                obj.getExchange().getText(),
                                String.valueOf(Math.abs(Integer.parseInt(order.getPosition()) - obj.getCurrentPosition())),
                                obj.getSecType().getText().replace("secType", ""),
                                obj.getLocalSymbol().getText().replace("localSymbol", ""),
                                obj.getContractID().getText().replace("contractId", ""),
                                false
                        );
                    }
                }
                obj.setCurrentPosition(Integer.parseInt(order.getPosition()));
                HashMap<Integer, DesktopObject> s = new HashMap<>();
                s.put(obj.getIdObject(), obj);
                cwm.save(s);
            }
//            if (obj.getTarget().getLabel()
//                    .equals("All") || obj.getTarget().getLabel()
//                    .equals("Mail")) {
//                test.sendSignal("SELL", "TS_1: Sell in signal at price " + obj.getSeccode().getText() + " " + " " + new Date());
//            }
        } catch (Exception e) {
            e.printStackTrace(new PrintWriter(wr));
            write_log("SELL", "orderlog.txt", wr.toString());
            wr.getBuffer().setLength(0);
        }
    }

    public synchronized void openHoldOrder(ParserApplication.Dialog dialog, JTextField text, int status, DesktopObject obj, ParserApplication.Test test, OrderWebHook order) {
        try {
            if (order == null || order.getPosition() == null) {
                if (status == 1) {
                    if (obj.getTarget().getLabel()
                            .equals("All") || obj.getTarget().getLabel()
                            .equals("Quik")) {
                        if (obj.getjCheckBox().isSelected()) {
                            createOrder(
                                    obj.getSeccode().getText(),
                                    obj.getExchange().getText(),
                                    obj.getQuantity().getText(),
                                    obj.getSecType().getText().replace("secType", ""),
                                    obj.getLocalSymbol().getText().replace("localSymbol", ""),
                                    obj.getContractID().getText().replace("contractId", ""),
                                    false
                            );
                        }
                    }
                    if(order!=null) {
                        if(order.getPrice()!=null) {
                            mapEq = obj.getEq().getS();
                            mapEq.add(order.getPrice());
                            obj.getEq().setS(mapEq);
                            obj.countLoss();
                            HashMap<Integer, DesktopObject> s = new HashMap<>();
                            s.put(obj.getIdObject(), obj);
                            cwm.save(s);
                        }
                    }
                } else if (status == -1) {
                    if (obj.getTarget().getLabel()
                            .equals("All") || obj.getTarget().getLabel()
                            .equals("Quik")) {
                        if (obj.getjCheckBox().isSelected()) {
                            createOrder(
                                    obj.getSeccode().getText(),
                                    obj.getExchange().getText(),
                                    obj.getQuantity().getText(),
                                    obj.getSecType().getText().replace("secType", ""),
                                    obj.getLocalSymbol().getText().replace("localSymbol", ""),
                                    obj.getContractID().getText().replace("contractId", ""),
                                    true
                            );
                        }
                    }
                    if(order!=null) {
                        if(order.getPrice()!=null) {
                            mapEq = obj.getEq().getB();
                            mapEq.add(order.getPrice().multiply(big));
                            obj.getEq().setB(mapEq);
                            obj.countLoss();
                            HashMap<Integer, DesktopObject> s = new HashMap<>();
                            s.put(obj.getIdObject(), obj);
                            cwm.save(s);
                        }
                    }
                }
            }
//            if (obj.getTarget().getLabel()
//                    .equals("All") || obj.getTarget().getLabel()
//                    .equals("Mail")) {
//                test.sendSignal("SELL", "TS_1: Hold in signal at price " + obj.getSeccode().getText() + " " + " " + new Date());
//            }
        } catch (Exception e) {
            StringWriter wr = new StringWriter();
            e.printStackTrace(new PrintWriter(wr));
            write_log("HOLD", "orderlog.txt", wr.toString());
            wr.getBuffer().setLength(0);
        }
    }

    //Запись текста в файл
    static void write_log(String text, String path, String content) {
        BufferedWriter wr = null;
        try {
            wr = new BufferedWriter(new FileWriter(path, true));
            wr.write(text + ":" + new Date() + " " + content);
            wr.write("\n");
            wr.flush();
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int createOrder(String symbol, String exchange, String quantity, String secType, String localSymbol, String contractId, boolean orderSide) {
        Contract contract = createContract(symbol, exchange, secType, localSymbol, contractId);
        // https://interactivebrokers.github.io/tws-api/classIBApi_1_1Order.html
        Order order = new Order();
        order.transmit(true);
        order.orderType("MKT");
        order.action(orderSide ? "BUY" : "SELL");
        order.totalQuantity(Integer.valueOf(quantity));

        return controller.placeOrModifyOrder(contract, order, null);
    }

    protected Contract createContract(String symbol, String exchange, String secType, String localSymbol, String contractId) {
        return new Contract(!contractId.isEmpty() && !contractId.equals("contractId") ? Integer.valueOf(contractId) : 0, symbol, secType, null, 0.0d, null,
                null, exchange,"", localSymbol, null, null,
                "SMART", false, null, null);
    }

    public JDialog getDialog() {
        dialog.setVisible(true);
        return dialog;
    }
}
