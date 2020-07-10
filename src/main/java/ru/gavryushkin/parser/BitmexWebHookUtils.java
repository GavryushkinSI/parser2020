package ru.gavryushkin.parser;

import ru.gavryushkin.parser.bitmex.Bitmex;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;

/**
 * Отправка заявок на битмекс по сигналам вебхуков
 */
public class BitmexWebHookUtils {

    private static StringWriter wr = new StringWriter();
    private static ArrayList<Integer> mapEq;

    public static void openBuyOrder(ParserApplication.Dialog dialog, JTextField text, String[] pozitionBitmex, int status, DesktopObject obj, ParserApplication.Test test) {
        try {
            if (status == -1) {
                if (obj.getTarget().getLabel()
                        .equals("All") || obj.getTarget().getLabel()
                        .equals("Quik")) {
                    Bitmex.createOrderBuy(
                            dialog.getIdField().getText(),
                            dialog.getKeyField().getText(),
                            String.valueOf(Integer.parseInt(obj.getQuantity().getText()) * 2),
                            dialog.getUrlBtn().getText());
                    pozitionBitmex = Bitmex.getPozition(dialog.getIdField().getText(),
                            dialog.getKeyField().getText(), dialog.getUrlBtn().getText());
                    mapEq = obj.getEq().getB();
                    mapEq.add((int) (Double.valueOf(pozitionBitmex[1]) * (-1)));
                    mapEq.add((int) (Double.valueOf(pozitionBitmex[1]) * (-1)));
                    obj.getEq().setB(mapEq);
                }
            } else if (status == 0) {
                if (obj.getTarget().getLabel()
                        .equals("All") || obj.getTarget().getLabel()
                        .equals("Quik")) {
                    Bitmex.createOrderBuy(
                            dialog.getIdField().getText(),
                            dialog.getKeyField().getText(),
                            obj.getQuantity().getText(),
                            dialog.getUrlBtn().getText());
                    pozitionBitmex = Bitmex.getPozition(dialog.getIdField().getText(),
                            dialog.getKeyField().getText(), dialog.getUrlBtn().getText());
                    mapEq = obj.getEq().getB();
                    mapEq.add((int) (Double.valueOf(pozitionBitmex[1]) * (-1)));
                    obj.getEq().setB(mapEq);
                }
            }
            text.setText("Покупка...");
            text.setText("Режим WebHooks активирован...");
            if (obj.getTarget().getLabel()
                    .equals("All") || obj.getTarget().getLabel()
                    .equals("Mail")) {
                test.sendSignal("BUY", "TS_1: Buy in signal at price " + obj.getSeccode().getText() + " " + pozitionBitmex[1] + " " + new Date());
            }
        } catch (Exception e) {
            text.setText("Ошибка отправки заявки на Bitmex");
            text.setText("Режим WebHooks активирован...");
            //JOptionPane.showMessageDialog(new JFrame("Message"), "Ошибка отправки заявки на Bitmex");
            e.printStackTrace(new PrintWriter(wr));
            write_log("BUY", "orderlog.txt", wr.toString());
            wr.getBuffer().setLength(0);
        }
    }

    public static void openSellOrder(ParserApplication.Dialog dialog, JTextField text, String[] pozitionBitmex, int status, DesktopObject obj, ParserApplication.Test test) {
        try {
            if (status == 1) {
                if (obj.getTarget().getLabel()
                        .equals("All") || obj.getTarget().getLabel()
                        .equals("Quik")) {
                    Bitmex.createOrderSell(
                            dialog.getIdField().getText(),
                            dialog.getKeyField().getText(),
                            String.valueOf(Integer.parseInt(obj.getQuantity().getText()) * 2),
                            dialog.getUrlBtn().getText());
                    pozitionBitmex = Bitmex.getPozition(dialog.getIdField().getText(),
                            dialog.getKeyField().getText(), dialog.getUrlBtn().getText());
                    mapEq = obj.getEq().getS();
                    mapEq.add((int) (Double.valueOf(pozitionBitmex[1]) * (1)));
                    mapEq.add((int) (Double.valueOf(pozitionBitmex[1]) * (1)));
                    obj.getEq().setS(mapEq);
                }
            } else if (status == 0) {
                if (obj.getTarget().getLabel()
                        .equals("All") || obj.getTarget().getLabel()
                        .equals("Quik")) {
                    Bitmex.createOrderSell(
                            dialog.getIdField().getText(),
                            dialog.getKeyField().getText(),
                            obj.getQuantity().getText(),
                            dialog.getUrlBtn().getText());
                    pozitionBitmex = Bitmex.getPozition(dialog.getIdField().getText(),
                            dialog.getKeyField().getText(), dialog.getUrlBtn().getText());
                    mapEq = obj.getEq().getS();
                    mapEq.add((int) (Double.valueOf(pozitionBitmex[1]) * (1)));
                    obj.getEq().setS(mapEq);
                }
            }
            text.setText("Продажа...");
            text.setText("Режим WebHooks активирован...");
            if (obj.getTarget().getLabel()
                    .equals("All") || obj.getTarget().getLabel()
                    .equals("Mail")) {
                test.sendSignal("SELL", "TS_1: Sell in signal at price " + obj.getSeccode().getText() + " " + pozitionBitmex[1] + " " + new Date());
            }
        } catch (Exception e) {
            text.setText("Ошибка отправки заявки на Bitmex");
            text.setText("Режим WebHooks активирован...");
            //JOptionPane.showMessageDialog(new JFrame("Message"), "Ошибка отправки заявки на Bitmex");
            e.printStackTrace(new PrintWriter(wr));
            write_log("SELL", "orderlog.txt", wr.toString());
            wr.getBuffer().setLength(0);
        }
    }

    public static void openHoldOrder(ParserApplication.Dialog dialog, JTextField text, String[] pozitionBitmex, int status, DesktopObject obj, ParserApplication.Test test) {
        try {
            if (status == 1) {
                if (obj.getTarget().getLabel()
                        .equals("All") || obj.getTarget().getLabel()
                        .equals("Quik")) {
                    Bitmex.createOrderSell(
                            dialog.getIdField().getText(),
                            dialog.getKeyField().getText(),
                            obj.getQuantity().getText(),
                            dialog.getUrlBtn().getText());
                    pozitionBitmex = Bitmex.getPozition(dialog.getIdField().getText(),
                            dialog.getKeyField().getText(), dialog.getUrlBtn().getText());
                    mapEq = obj.getEq().getS();
                    mapEq.add((int) (Double.valueOf(pozitionBitmex[1]) * (1)));
                    obj.getEq().setS(mapEq);
                }
            } else if (status == -1) {
                if (obj.getTarget().getLabel()
                        .equals("All") || obj.getTarget().getLabel()
                        .equals("Quik")) {
                    Bitmex.createOrderBuy(
                            dialog.getIdField().getText(),
                            dialog.getKeyField().getText(),
                            obj.getQuantity().getText(),
                            dialog.getUrlBtn().getText());
                    pozitionBitmex = Bitmex.getPozition(dialog.getIdField().getText(),
                            dialog.getKeyField().getText(), dialog.getUrlBtn().getText());
                    mapEq = obj.getEq().getB();
                    mapEq.add((int) (Double.valueOf(pozitionBitmex[1]) * (-1)));
                    obj.getEq().setB(mapEq);
                }
            }
            text.setText("Выход из позиции...");
            text.setText("Режим WebHooks активирован...");
            if (obj.getTarget().getLabel()
                    .equals("All") || obj.getTarget().getLabel()
                    .equals("Mail")) {
                test.sendSignal("SELL", "TS_1: Hold in signal at price " + obj.getSeccode().getText() + " " + pozitionBitmex[1] + " " + new Date());
            }
        } catch (Exception e) {
            StringWriter wr = new StringWriter();
            e.printStackTrace(new PrintWriter(wr));
            write_log("HOLD", "orderlog.txt", wr.toString());
            text.setText("Ошибка отправки заявки на Bitmex");
            text.setText("Режим WebHooks активирован...");
            //JOptionPane.showMessageDialog(new JFrame("Message"), "Ошибка отправки заявки на Bitmex");
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
}
