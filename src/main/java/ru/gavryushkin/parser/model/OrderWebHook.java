package ru.gavryushkin.parser.model;

import java.io.Serializable;
import java.math.BigDecimal;

//Модель заявки для вебхуков
public class OrderWebHook implements Serializable {
    //Наименование стратегии
    private String nameTs;

    //направлении позиции
    private String operation;

    //размер позиции
    private String position;

    //Цена исполнения сигнала из TradingView
    private BigDecimal price;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getNameTs() {
        return nameTs;
    }

    public void setNameTs(String nameTs) {
        this.nameTs = nameTs;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
