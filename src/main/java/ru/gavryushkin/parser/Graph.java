package ru.gavryushkin.parser;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Graph implements Serializable {
    private ArrayList<BigDecimal> b;
    private ArrayList<BigDecimal> s;

    public Graph() {
        this.b = new ArrayList<>();
        this.s = new ArrayList<>();
    }

    public ArrayList<BigDecimal> getB() {
        return b;
    }

    public void setB(ArrayList<BigDecimal> b) {
        this.b = b;
    }

    public ArrayList<BigDecimal> getS() {
        return s;
    }

    public void setS(ArrayList<BigDecimal> s) {
        this.s = s;
    }

    public ArrayList<BigDecimal> getTotal() {
        ArrayList<BigDecimal> total = null;
        int size = b.size() > s.size() ? s.size() : b.size();
        if (b.size() != 0 && s.size() != 0) {
            total = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                total.add(b.get(i).add(s.get(i)));
            }
        }
        if (total == null) {
            return new ArrayList<>();
        }

        return total;
    }

    public String getTotalResult() {
        BigDecimal x = BigDecimal.ZERO;
        List<BigDecimal> total = getTotal();
        if (total.size() != 0) {
            x = total.stream().reduce(BigDecimal::add).get();
        }
        return String.valueOf(x);
    }

    @Override
    public String toString() {
        return "Graph{" +
                "b=" + b +
                ", s=" + s +
                '}';
    }
}
