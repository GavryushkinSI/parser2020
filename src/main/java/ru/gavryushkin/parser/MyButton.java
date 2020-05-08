package ru.gavryushkin.parser;

import javax.swing.*;
import java.io.Serializable;

public class MyButton extends JButton implements Serializable {
    private int idObject;

    public MyButton(ImageIcon icon, int idObject) {
        super(icon);
        this.idObject = idObject;
    }

    public int getIdObject() {
        return idObject;
    }

    public void setIdObject(int idObject) {
        this.idObject = idObject;
    }
}
