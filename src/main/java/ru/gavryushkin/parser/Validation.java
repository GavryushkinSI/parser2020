package ru.gavryushkin.parser;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//Проверяет соответсвие позиций в Quik  c позицией в ParseSignal. В случае разногласий отправляет сообщение на почту.
public class Validation implements Runnable{
    //private static int count=0;
    public static int getPoz_quik() {
        return poz_quik;
    }

    public static int  poz_quik;

     ParserApplication.MyRunnable run=null;
     ParserApplication.Test obj=null;
     ParserApplication.Dialog dialog=null;
     JTextField text=null;
    //Calendar c=Calendar.getInstance();
    //DateFormat df=new SimpleDateFormat("u");
    Validation(ParserApplication.MyRunnable run, ParserApplication.Test obj, ParserApplication.Dialog dialog, JTextField text){
        this.run=run;
        this.obj=obj;
        this.text=text;
        this.dialog=dialog;
    }
    @Override
    public void run() {
        //boolean time=Integer.parseInt(df.format(c.getTime()))<=5;
        while(ParserApplication.work!=false) {
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                poz_quik = read_file("val.txt");
                System.out.println(ParserApplication.size);
                if (ParserApplication.size != poz_quik) {
                    System.out.println(ParserApplication.size+" poz quik : "+poz_quik);
                    //count++;
                    //if(count>=2) {
                        obj.sendSignal("Позиции  не совпадают, сделайте ручную корректировку.", "");
                        System.out.println("Позиции  не совпадают, сделайте ручную корректировку.");
                    }

//               else{count=0;}
////                System.out.println("COUNT: "+count);
                try {
                    Thread.sleep(12000);
                } catch (InterruptedException e) {
                    text.setText("Validation thread interrupted");
                    obj.sendSignal("Прерван поток Validation", "");
                }
            }
        }

    int read_file(String path) {
        BufferedReader rd = null;
        String[] x = null;
        try {
            rd = new BufferedReader(new FileReader(path));
            x = rd.readLine().split(" ");
            rd.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(x[0]);
    }

}
