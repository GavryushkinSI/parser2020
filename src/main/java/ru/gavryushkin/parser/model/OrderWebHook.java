package ru.gavryushkin.parser.model;

import java.io.Serializable;

//Модель заявки для вебхуков
public class OrderWebHook implements Serializable {
    //Наименование стратегии
    private String nameTs;

    //направлении позиции
    private String operation;

    //размер позиции
    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
