package ru.gavryushkin.parser;

import java.util.ArrayList;

public class Martin {
      int y=0;
      static ArrayList<Integer> index = new ArrayList<Integer>();
      static int level=0;
      final int begin_quantity;
      Martin(ParserApplication.Dialog dialog){
          begin_quantity = Integer.parseInt(dialog.getQuantitytext());

  }


      public int coefficient(){
          if(ParserApplication.list.size()==0||ParserApplication.list.get(ParserApplication.list.size()-1)>level){
              ParserApplication.list.clear();
              System.out.println("Список очищен");
              y=begin_quantity;
              System.out.println(y);
              return y;
          }
          else {
              try {
                  if (ParserApplication.list.get(ParserApplication.list.size() - 1) < 0 || ParserApplication.list.get(ParserApplication.list.size() - 1) <= level) {
                      y = index.get(ParserApplication.list.size() - 1);
                      System.out.println(y);
                      return y;
                  }
              }
              catch(Exception ex){
                  if(index.size()!=0) {
                      y = index.get(index.size() - 1);
                      System.out.println(y);
                      return y;
                  }
                  else {
                      y=begin_quantity;
                      System.out.println(y);
                      return y;
                  }
              }

              }

        return y;
      }
}
