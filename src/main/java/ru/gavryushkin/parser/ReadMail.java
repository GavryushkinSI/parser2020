package ru.gavryushkin.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Модуль обратной связи с SMTP для выставления заявок
 */
public class ReadMail implements Runnable {
    ParserApplication.Test obj = null;
    ParserApplication.Trade trade = null;

    public ReadMail(ParserApplication.Test obj, ParserApplication.Trade trade) {
        this.obj = obj;
        this.trade = trade;
    }

    @Override
    public void run() {
        System.out.println("Модуль обратной связи SMTP запущен");
        while (ParserApplication.work == false) {
            try {
                BufferedReader rd = new BufferedReader(new FileReader("readbox.txt"));
                String x = rd.readLine();
                System.out.println("Readbox: " + x);
                rd.close();
                if (x.equalsIgnoreCase("screen")) {
                    obj.sendSignal("Скрин", "");
                }
                if (x.equalsIgnoreCase("buy")) {
                    trade.Order_B();
                    obj.sendSignal("Покупка", "");
                }
                if (x.equalsIgnoreCase("sell")) {
                    trade.Order_S();
                    obj.sendSignal("Продажа", "");
                }
                Thread.sleep(20000);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

