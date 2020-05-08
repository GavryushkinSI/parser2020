package ru.gavryushkin.parser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.Serializable;

public class PTextField extends JTextField implements Serializable {

    public PTextField(final String proptText) {
        super(proptText);
        setForeground(Color.GRAY);
        addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                if(getText().isEmpty()) {
                    setText(proptText);
                    setForeground(Color.GRAY);
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if(getText().equals(proptText)) {
                    setText("");
                    setForeground(Color.BLACK);
                }
            }
        });

    }

}
