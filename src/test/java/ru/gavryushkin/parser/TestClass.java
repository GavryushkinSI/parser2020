package ru.gavryushkin.parser;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.gavryushkin.parser.bitmex.Bitmex;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Класс тестов приложения
 */
public class TestClass {
    private static ParserApplication app = null;
    private final static String URL = "http://localhost/webHook";

    @Before
    public void init() {
        app = new ParserApplication();
//        JettyApplication jettyApplication=new JettyApplication(app.tr);
//        jettyApplication.startServerJetty();
        app.createGUI();
        app.frame.setVisible(false);
        clean();
    }

    /**
     * Тест покупки продажи выхода из позиции
     */
    @Test
    public void TestBuyAndSellOrder() {
        ParserApplication.size = 0;
        app.dialog.getSeparateOrderCheckBox().setSelected(false);
        app.dialog.setCbFirst(new JComboBox<>(new String[]{"Si RUB "}));
        JTextField textField = new JTextField();
        textField.setText(String.valueOf(new Random().nextInt(10)));
        app.dialog.setQuantitytext(textField);
        app.price = "1000";
        app.status = 0;
        app.tr.Order_Buy();
        Assert.assertTrue(read().get(0).contains("SPBFUT"));
        Assert.assertEquals((int) Integer.valueOf(textField.getText()), ParserApplication.size);
        Assert.assertEquals(1, read().size());
        app.status = 1;
        app.tr.Order_Sell();
        Assert.assertEquals(Integer.parseInt(textField.getText()) * (-1), ParserApplication.size);
        Assert.assertEquals(2, read().size());
        app.status = -1;
        app.tr.Order_HOLD();
        Assert.assertEquals(3, read().size());
        Assert.assertEquals(0, ParserApplication.size);
    }

    /**
     * Тест раздельной покупки продажи выхода из позиции для снижения ГО
     */
    @Test
    public void TestSeparateBuyAndSellOrder() {
        JTextField textField = new JTextField();
        textField.setText("2");
        ParserApplication.size = Integer.parseInt(textField.getText()) * (-1);
        app.dialog.setCbFirst(new JComboBox<>(new String[]{"Si RUB "}));
        app.dialog.setQuantitytext(textField);
        app.price = "1000";
        app.status = -1;
        app.dialog.getSeparateOrderCheckBox().setSelected(true);
        app.tr.Order_Buy();
        Assert.assertEquals(2, ParserApplication.size);
        Assert.assertEquals(2, read().size());
        app.status = 1;
        app.tr.Order_Sell();
        Assert.assertEquals(-2, ParserApplication.size);
        Assert.assertEquals(4, read().size());
        app.status = -1;
        app.tr.Order_HOLD();
        Assert.assertEquals(5, read().size());
        Assert.assertEquals(0, ParserApplication.size);
    }

    /**
     * Очитска файла транзакций
     */
    private void clean() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("trade.tri", false));
            writer.write("");
            writer.flush();
            writer.close();
            int poz = Integer.parseInt(getPozBitmex());
            app.dialog.getSeparateOrderCheckBox().setSelected(true);
            app.dialog.setCbFirst(new JComboBox<>(new String[]{"XBTUSD "}));
            JTextField textField = new JTextField();
            textField.setText(getPozBitmex());
            app.dialog.setQuantitytext(textField);
            if (poz > 0) {
                app.status = 1;
                app.tr.Order_HOLD();
            } else if (poz < 0) {
                app.status = -1;
                textField.setText(String.valueOf(Math.abs(Integer.parseInt(getPozBitmex()))));
                app.tr.Order_HOLD();
            }
            app.status = 0;
            app.dialog.getSeparateOrderCheckBox().setSelected(false);
            ParserApplication.size = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Тест покупки продажи выхода из позиции Bitmex
     */
    @Test
    public void TestBuyAndSellOrderBitmex() {
        ParserApplication.size = 0;
        app.dialog.getSeparateOrderCheckBox().setSelected(false);
        app.dialog.setCbFirst(new JComboBox<>(new String[]{"XBTUSD "}));
        JTextField textField = new JTextField();
        textField.setText(String.valueOf(2));
        app.dialog.setQuantitytext(textField);
        app.status = 0;
        sleep(2000);
        app.tr.Order_Buy();
        Assert.assertEquals(textField.getText(), getPozBitmex());
        app.status = 1;
        app.tr.Order_Sell();
        Assert.assertEquals(String.valueOf(Integer.parseInt(textField.getText())), getPozBitmex());
        app.status = -1;
        sleep(2000);
        app.tr.Order_HOLD();
        Assert.assertEquals("0", getPozBitmex());
    }

    /**
     * Чтения  текста из файла
     */
    private List<String> read() {
        List<String> listOrder = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("trade.tri"));
            while (reader.ready()) {
                listOrder.add(reader.readLine());
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOrder;
    }

    /**
     * Тест покупки продажи выхода из позиций акции
     */
    @Test
    public void TestOrderStock() {
        JTextField textField = new JTextField();
        textField.setText("2");
        ParserApplication.size = 0;
        app.dialog.getSeparateOrderCheckBox().setSelected(false);
        app.dialog.setCbFirst(new JComboBox<>(new String[]{"STOCK "}));
        app.dialog.setQuantitytext(textField);
        app.status = 0;
        app.tr.Order_Buy();
        Assert.assertEquals(1, read().size());
        Assert.assertTrue(read().get(0).contains("TQBR"));
        Assert.assertEquals("0", app.price);
        Assert.assertEquals(2, ParserApplication.size);
        app.status = 1;
        app.tr.Order_Sell();
        Assert.assertEquals(-2, ParserApplication.size);
        Assert.assertEquals(2, read().size());
        app.status = -1;
        app.tr.Order_HOLD();
        Assert.assertEquals(3, read().size());
        Assert.assertEquals(0, ParserApplication.size);
    }

    /**
     * Тест отправки почты по SMTP
     */
    @Test
    public void TestSendMessage() {
        app.test.sendSignal("test", "test");
        JTextField textField1 = new JTextField();
        textField1.setText("parsesignal@yandex.ru");
        app.dialog.setMail(textField1);
        JTextField textField2 = new JTextField();
        textField2.setText("aspeka25y");
    }

    /**
     * Тест режима WebHooks
     */
    @Test
    public void TestWebHooksMode() {
        ParserApplication.size = 0;
        app.dialog.getSeparateOrderCheckBox().setSelected(false);
        app.dialog.setCbFirst(new JComboBox<>(new String[]{"Si RUB "}));
        app.dialog.getBoxtrade().setState(true);
        JTextField textField = new JTextField();
        textField.setText(String.valueOf(2));
        app.dialog.setQuantitytext(textField);
        app.price = "1000";
        app.status = 0;
        //Buy
        app.tr.sendSignalWebHook(1);
        app.status = 1;
        Assert.assertEquals(2, ParserApplication.size);
        Assert.assertEquals(1, read().size());
        //Sell
        app.tr.sendSignalWebHook(-1);
        app.status = -1;
        Assert.assertEquals(-2, ParserApplication.size);
        Assert.assertEquals(2, read().size());
        //Hold
        app.tr.sendSignalWebHook(0);
        Assert.assertEquals(0, ParserApplication.size);
        Assert.assertEquals(3, read().size());
    }

    /**
     * Получение позиции Bitmex
     */
    private String getPozBitmex() {
        String[] pozitionBitmex = Bitmex.getPozition(
                app.dialog.getIdField().getText(),
                app.dialog.getKeyField().getText());
        return pozitionBitmex[0];
    }

    /**
     * Приостановить поток на мс
     *
     * @return
     */
    private void sleep(long ms) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void finishTest() {
        clean();
    }
}


