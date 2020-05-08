package ru.gavryushkin.parser;

import java.io.Serializable;
import java.util.ArrayList;

public class Graph implements Serializable {
    private ArrayList<Integer> b;
    private ArrayList<Integer> s;

    public Graph() {
        this.b = new ArrayList<>();
        this.s=new ArrayList<>();
    }

    public ArrayList<Integer> getB() {
        return b;
    }

    public void setB(ArrayList<Integer> b) {
        this.b = b;
    }

    public ArrayList<Integer> getS() {
        return s;
    }

    public void setS(ArrayList<Integer> s) {
        this.s = s;
    }

    public ArrayList<Integer> getTotal(){
        ArrayList<Integer>  total=null;
        int size=b.size()>s.size()?s.size():b.size();
        if(b.size()!=0&&s.size()!=0){
           total =new ArrayList<>();
            for(int i=0;i<size;i++){
                total.add(b.get(i)+s.get(i));
            }
        }
        if(total==null) {
            return new ArrayList<>();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "b=" + b +
                ", s=" + s +
                '}';
    }
}
