package ru.gavryushkin.parser.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Equity implements Serializable {
    List<Point> list=new ArrayList<>();

    public List<Point> getList() {
        return list;
    }

    public void setList(List<Point> list) {
        this.list = list;
    }
}
