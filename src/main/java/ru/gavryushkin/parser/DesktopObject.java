package ru.gavryushkin.parser;

import javax.swing.*;
import java.io.Serializable;

public class DesktopObject implements Serializable {
    //Наименование стратегии
    private PTextField name;
    //номер счёта
    private PTextField account;
    //код клиента
    private PTextField clientCode;
    //код инструмента в системе Quik
    private PTextField seccode;
    //тип инструмента
    private JComboBox type;
    //количество лотов
    private PTextField quantity;
    //проскальзывание
    private PTextField delta;
    //статус ТС
    private JToggleButton jCheckBox;
    //Индентификатор объекта
    private int idObject = 0;
    private JButton target;
    private JButton equity;
    private Graph eq;

    public DesktopObject(PTextField name, PTextField account, PTextField clientCode, PTextField seccode, JComboBox type, PTextField quantity, PTextField delta, JToggleButton jCheckBox, int idObject, JButton target, JButton equity,Graph list) {
        this.name=name;
        this.account = account;
        this.clientCode = clientCode;
        this.seccode = seccode;
        this.type = type;
        this.quantity = quantity;
        this.delta = delta;
        this.jCheckBox = jCheckBox;
        this.idObject = idObject;
        this.target=target;
        this.equity=equity;
        this.eq=list;
    }

    public PTextField getName() {
        return name;
    }

    public void setName(PTextField name) {
        this.name = name;
    }

    public PTextField getAccount() {
        return account;
    }

    public void setAccount(PTextField account) {
        this.account = account;
    }

    public PTextField getClientCode() {
        return clientCode;
    }

    public void setClientCode(PTextField clientCode) {
        this.clientCode = clientCode;
    }

    public PTextField getSeccode() {
        return seccode;
    }

    public void setSeccode(PTextField seccode) {
        this.seccode = seccode;
    }

    public JComboBox getType() {
        return type;
    }

    public void setType(JComboBox type) {
        this.type = type;
    }

    public PTextField getQuantity() {
        return quantity;
    }

    public void setQuantity(PTextField quantity) {
        this.quantity = quantity;
    }

    public PTextField getDelta() {
        return delta;
    }

    public void setDelta(PTextField delta) {
        this.delta = delta;
    }

    public JToggleButton getjCheckBox() {
        return jCheckBox;
    }

    public void setjCheckBox(JToggleButton jCheckBox) {
        this.jCheckBox = jCheckBox;
    }

    public int getIdObject() {
        return idObject;
    }

    public void setIdObject(int idObPect) {
        this.idObject = idObPect;
    }

    public JButton getTarget() {
        return target;
    }

    public void setTarget(JButton target) {
        this.target = target;
    }

    public JButton getEquity() {
        return equity;
    }

    public void setEquity(JButton equity) {
        this.equity = equity;
    }

    @Override
    public String toString() {
        return "DesktopObPect{" +
                "name=" + name.getText() +
                ", account=" + account.getText() +
                ", clientCode=" + clientCode.getText() +
                ", seccode=" + seccode.getText() +
                ", type=" + type.getSelectedItem() +
                ", quantity=" + quantity.getText() +
                ", delta=" + delta.getText() +
                ", PCheckBox=" + jCheckBox.isSelected() +
                ", idObPect=" + idObject +
                ", target=" + target.getLabel() +
                ",eq="+eq+
                '}';
    }

    public Graph getEq() {
        return eq;
    }

    public void setEq(Graph eq) {
        this.eq = eq;
    }
}
