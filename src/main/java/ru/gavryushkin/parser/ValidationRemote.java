package ru.gavryushkin.parser;

public class ValidationRemote implements Runnable {
    private static int  count =0;
     ParserApplication.MyRunnable run=null;
     ParserApplication.Test obj=null;
    ValidationRemote(ParserApplication.MyRunnable run, ParserApplication.Test obj){
        this.run=run;
        this.obj=obj;
    }
    @Override
    public void run() {
        while(ParserApplication.work!=false) {
                System.out.println("unique_pixels: " + run.count_unique);
                if (run.count_unique < 300) {
                    //count++;
                    obj.sendSignal("FATAL ERROR", "Некорректное сканироваание: в сканируемом изображении не найденно ни одного дубликата");
                    System.out.println("Некорректное сканирование: в сканируемом изображении не найденно ни одного дубликата");

                }

                try {
                    Thread.sleep(300000);
                } catch (InterruptedException e) {
                    System.out.println("Прерван поток ValidationRemote");
                }
            }
        }
    }

