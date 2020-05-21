package ru.gavryushkin.parser;

import ru.gavryushkin.parser.ParserApplication.WebHooksModule;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkEvent.EventType;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class My_JMenuBar extends JMenuBar {
    private CustomWebHooksModule customWebHooksModule;
    private WebHooksModule webHooksModule;
    private static String HOST = "";
    String[] items = new String[]{"Menu", "Clear Equity", "?Help", "GetUrl", "Custom WebHooks", "Skip Set WebHooks"};
    JMenu menu;
    JMenuItem item_1;
    JMenuItem item_2;
    JMenuItem item_3;
    JMenuItem item_4;
    JMenuItem item_5;
    static Checkbox check = new Checkbox("Set Validation");

    public static boolean getCheck() {
        return check.getState();
    }

    public My_JMenuBar(CustomWebHooksModule customWebHooksModule, WebHooksModule webHooksModule) {
        this.menu = new JMenu(this.items[0]);
        this.item_1 = new JMenuItem(this.items[1]);
        this.item_2 = new JMenuItem(this.items[2]);
        this.item_3 = new JMenuItem(this.items[3]);
        this.item_4 = new JMenuItem(this.items[4]);
        this.item_5 = new JMenuItem(this.items[5]);
        this.add(this.create_menu());
        check.setState(true);
        this.customWebHooksModule = customWebHooksModule;
        this.webHooksModule = webHooksModule;
    }

    public JMenu create_menu() {
        final JEditorPane ep = new JEditorPane("text/html", "Инструкция:<a href=\"https://yadi.sk/i/P4hc3plB3adhGQ\">?Help</a>\n<br>_________Parse_Signal_v.3.0__________");
        ep.addHyperlinkListener(new HyperlinkListener() {
            public void hyperlinkUpdate(HyperlinkEvent e) {
                try {
                    if (e.getEventType().equals(EventType.ACTIVATED)) {
                        Desktop.getDesktop().browse(new URI("https://yadi.sk/i/P4hc3plB3adhGQ"));
                    }
                } catch (Exception var3) {
                    var3.printStackTrace();
                }

            }
        });
        ep.setEditable(false);
        this.item_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                My_JMenuBar.this.write_file("data.txt", "");
            }
        });
        this.item_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(new JFrame("INFO"), ep);
            }
        });
        this.item_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringSelection stringSelection = new StringSelection("http://" + My_JMenuBar.this.getHost() + "/webHook");
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, (ClipboardOwner)null);
            }
        });
        this.item_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                My_JMenuBar.this.customWebHooksModule.getFrame().setVisible(true);
                System.out.println(My_JMenuBar.this.customWebHooksModule.getMap().size());
            }
        });
        this.item_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object[] options = new Object[]{"Да", "Нет"};
                int n = JOptionPane.showOptionDialog(My_JMenuBar.this.item_5, "Данная операция сбросит все настройки вебхуков?", "Message", 0, 3, (Icon)null, options, options[0]);
                if (n == 0) {
                    System.out.println("Сброс настроек WebHook");
                    My_JMenuBar.this.write_file("buylist.ser", "");
                    My_JMenuBar.this.write_file("selllist.ser", "");
                    My_JMenuBar.this.write_file("holdlist.ser", "");
                    My_JMenuBar.this.write_file("server-log.txt", "");
                    My_JMenuBar.this.write_file("fut.txt", "codeQuik,");
                    My_JMenuBar.this.write_file("stock.txt", "codeQuik,");
                    My_JMenuBar.this.write_file("quote.txt", "SI:1000");
                    My_JMenuBar.this.webHooksModule.getBuyList().clear();
                    My_JMenuBar.this.webHooksModule.getSellList().clear();
                    My_JMenuBar.this.webHooksModule.getHoldList().clear();
                    Iterator entries = My_JMenuBar.this.customWebHooksModule.getMap().entrySet().iterator();

                    while(entries.hasNext()) {
                        DesktopObject object = (DesktopObject)((Entry)entries.next()).getValue();
                        object.setEq(new Graph());
                        HashMap<Integer, DesktopObject> m = My_JMenuBar.this.customWebHooksModule.getMap();
                        m.put(object.getIdObject(), object);
                        My_JMenuBar.this.customWebHooksModule.save(m);
                    }
                }

            }
        });
        this.menu.add(this.item_1);
        this.menu.add(this.item_2);
        this.menu.add(this.item_3);
        this.menu.add(this.item_4);
        this.menu.add(this.item_5);
        this.menu.setIcon(new ImageIcon("/Users/bootcamp/Desktop/Different/parser/src/main/java/ru/gavryushkin/parser/icon/icons8-меню-20.png"));
        return this.menu;
    }

    void write_file(String path, String content) {
        BufferedWriter wr = null;

        try {
            wr = new BufferedWriter(new FileWriter(path, false));
            wr.write(content);
            wr.flush();
            wr.close();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }

    private String getHost() {
        try {
            return HOST = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException var2) {
            var2.printStackTrace();
            return null;
        }
    }
}