package ru.gavryushkin.parser;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;

public class My_JMenuBar extends JMenuBar {
    private static String HOST="";
    String[] items = {"Menu", "Clear Equity", "?Help", "GetUrl"};
    JMenu menu = new JMenu(items[0]);
    JMenuItem item_1 = new JMenuItem(items[1]);
    JMenuItem item_2 = new JMenuItem(items[2]);
    JMenuItem item_3 = new JMenuItem(items[3]);
    static Checkbox check = new Checkbox("Set Validation");

    public static boolean getCheck() {
        return check.getState();
    }

    public My_JMenuBar() {
        super();
        this.add(create_menu());
        check.setState(true);
    }

    public JMenu create_menu() {
        JEditorPane ep = new JEditorPane("text/html",
                "Инструкция:<a href=\"https://yadi.sk/i/P4hc3plB3adhGQ\">?Help</a>\n" +
                        "<br>_________Parse_Signal_v.3.0__________");

        // handle link events
        ep.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                try {
                    if (e.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED))
                        Desktop.getDesktop().browse(new URI("https://yadi.sk/i/P4hc3plB3adhGQ"));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        ep.setEditable(false);
        item_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                write_file("data.txt", "");
            }
        });
        item_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(new JFrame("INFO"), ep);
            }
        });
        item_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection stringSelection = new StringSelection("http://"+getHost()+"/webHook");
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
            }
        });
        menu.add(item_1);
        menu.add(item_2);
        menu.add(item_3);
        return menu;
    }

    void write_file(String path, String content) {
        BufferedWriter wr = null;
        try {
            wr = new BufferedWriter(new FileWriter(path, false));
            wr.write(content);
            wr.flush();
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getHost() {
        try {
            return HOST = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }
}
