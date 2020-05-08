package ru.gavryushkin.parser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CustomWebHooksModule {
    private volatile Map<String, String> infoPrice = new HashMap<>();
    private volatile HashMap<Integer, DesktopObject> map = new HashMap<>();
    private static int idObject = 0;
    private static int i = 0;
    private static int n = 0;
    private JDialog frame = null;
    private ArrayList<String> buyList;
    private ArrayList<String> sellList;
    private ArrayList<String> holdList;
    private Color dark = new Color(2, 2, 2, 179);
    private Color col1 = new Color(52, 105, 184);
    private Color blueDark = new Color(34, 69, 112);
    private Color darkLight = new Color(53, 58, 58, 186);
    private Color green = new Color(24, 143, 57);
    private Color red = new Color(202, 52, 59);
    private Color blueLight = new Color(24, 117, 116);
    private ParserApplication.Dialog dialog;
    private JTextField lineState;

    public CustomWebHooksModule(ParserApplication.Dialog dialog) {
        this.dialog = dialog;
    }

    public void init() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        System.out.println(map.size());
        //UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
        frame = new JDialog(ParserApplication.frame, "CUSTOM WEBHOOKS MODULE");
        frame.setIconImage(new ImageIcon("icon/icons8-webhook-22.png").getImage());
        frame.setBounds(300, 300, 1200, 90);
        JButton button = new JButton("ADD STRATEGY", new ImageIcon("icon/icons8-add-20.png"));
        button.setBackground(blueDark);
        button.setForeground(Color.white);
        frame.add(button, BorderLayout.NORTH);
        lineState=new JTextField();
        JPanel panel = new JPanel(new BorderLayout());
        GridLayout gridLayout = new GridLayout(0, 13);
        JPanel gridPanel = new JPanel(gridLayout);
        initialize(gridPanel, frame);
        System.out.println(map.size());
        //frame.getContentPane().setBackground(dark);
        idObject = map.size();
        JScrollPane screenScroll = new JScrollPane(gridPanel);
        panel.add(screenScroll);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PTextField name = new PTextField("nameTS");
                PTextField account = new PTextField("account");
                account.setText(dialog.getAccounttext());
                account.setForeground(Color.black);
                PTextField clientCode = new PTextField("clientCode");
                clientCode.setForeground(Color.black);
                clientCode.setText(dialog.getClientcodetext());
                PTextField secCode = new PTextField("codeQuik");
                JComboBox type = new JComboBox(new String[]{"SPBFUT", "TQBR"});
                type.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        if (type.getSelectedItem().equals("SPBFUT")) {
                            account.setText(dialog.getAccounttext());
                        } else {
                            account.setText(dialog.getAccounttext_2().getText());
                        }
                    }
                });
                PTextField quantity = new PTextField("quantity");
                PTextField delta = new PTextField("delta");
                JButton equity = new JButton("EQ", new ImageIcon("icon/icons8-graph-20.png"));
                equity.setBackground(dark);
                equity.setForeground(Color.white);
                JToggleButton jCheckBox = new JToggleButton("OFF");
                jCheckBox.setSelected(false);
                jCheckBox.setBackground(col1);
                jCheckBox.setForeground(Color.white);
                JButton target = new JButton("All", new ImageIcon("icon/icons8-all-20.png"));
                DesktopObject object = new DesktopObject(name, account, clientCode, secCode, type, quantity, delta, jCheckBox, idObject++, target, equity, new Graph());
                equity.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            new LineChart1("EQ", object.getEq().getTotal()).create_graphics("EQ", object.getEq().getTotal());
                            object.getEq().getTotal().forEach(n -> System.out.println(n));
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                });
                jCheckBox.setOpaque(false);
                gridPanel.add(object.getName());
                gridPanel.add(object.getAccount());
                gridPanel.add(object.getClientCode());
                gridPanel.add(object.getSeccode());
                gridPanel.add(object.getType());
                gridPanel.add(object.getQuantity());
                gridPanel.add(object.getDelta());
                gridPanel.add(object.getjCheckBox());
                gridPanel.add(object.getTarget());
                gridPanel.add(object.getEquity());
                MyButton apply = new MyButton(new ImageIcon("icon/icons8-save-20.png"), object.getIdObject());
                apply.setBackground(dark);
                apply.setForeground(Color.white);
                MyButton edit = new MyButton(new ImageIcon("icon/icons8-edit-20.png"), object.getIdObject());
                edit.setBackground(dark);
                edit.setForeground(Color.white);
                MyButton del = new MyButton(new ImageIcon("icon/icons8-delete-20.png"), object.getIdObject());
                del.setBackground(dark);
                del.setForeground(Color.white);
                target.setBackground(dark);
                target.setForeground(Color.white);
                target.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (n == 0) {
                            n = 1;
                            target.setLabel("All");
                            target.setIcon(new ImageIcon("icon/icons8-all-20.png"));
                        } else if (n == 1) {
                            n = 2;
                            target.setLabel("Mail");
                            target.setIcon(new ImageIcon("icon/icons8-mail-20.png"));
                        } else if (n == 2) {
                            n = 0;
                            target.setLabel("Quik");
                            target.setIcon(new ImageIcon("icon/icons8-account-20.png"));
                        }
                    }
                });
                map.put(apply.getIdObject(), object);
                save(map);
                map.forEach((k, v) -> System.out.println("Item : " + k + " Object : " + v));
                jCheckBox.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (jCheckBox.isSelected()) {
                            jCheckBox.setBackground(green);
                            jCheckBox.setText("ON");
                            jCheckBox.setForeground(Color.white);
                        } else {
                            jCheckBox.setText("OFF");
                            jCheckBox.setBackground(col1);
                            jCheckBox.setForeground(Color.white);
                        }
                    }
                });
                apply.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        name.setEnabled(false);
                        account.setEnabled(false);
                        clientCode.setEnabled(false);
                        secCode.setEnabled(false);
                        type.setEnabled(false);
                        quantity.setEnabled(false);
                        delta.setEnabled(false);
                        jCheckBox.setEnabled(false);
                        target.setEnabled(false);
                        name.setBackground(Color.LIGHT_GRAY);
                        account.setBackground(Color.LIGHT_GRAY);
                        clientCode.setBackground(Color.LIGHT_GRAY);
                        secCode.setBackground(Color.LIGHT_GRAY);
                        type.setBackground(Color.LIGHT_GRAY);
                        quantity.setBackground(Color.LIGHT_GRAY);
                        delta.setBackground(Color.LIGHT_GRAY);
                        boolean status = jCheckBox.isSelected();
                        jCheckBox.setBackground(status == true ? green : null);
                        jCheckBox.setOpaque(status == true ? true : false);
                        map.put(apply.getIdObject(), object);
                        writeCode(object.getType().getSelectedItem().toString());
                        getPriceFromQuik();
                        save(map);
                        System.out.println(buyList);
                        System.out.println(sellList);
                        System.out.println(holdList);
                    }
                });
                edit.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        name.setEnabled(true);
                        account.setEnabled(true);
                        clientCode.setEnabled(true);
                        secCode.setEnabled(true);
                        type.setEnabled(true);
                        quantity.setEnabled(true);
                        delta.setEnabled(true);
                        jCheckBox.setEnabled(true);
                        target.setEnabled(true);
                        name.setBackground(Color.white);
                        account.setBackground(Color.white);
                        clientCode.setBackground(Color.white);
                        secCode.setBackground(Color.white);
                        type.setBackground(Color.white);
                        quantity.setBackground(Color.white);
                        delta.setBackground(Color.white);
                        boolean status = jCheckBox.isSelected();
                        jCheckBox.setBackground(status == true ? green : col1);
                        jCheckBox.setOpaque(false);
                    }
                });
                del.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        DesktopObject obj = map.get(del.getIdObject());
                        gridPanel.remove(obj.getName());
                        gridPanel.remove(obj.getAccount());
                        gridPanel.remove(obj.getName());
                        gridPanel.remove(obj.getClientCode());
                        gridPanel.remove(obj.getQuantity());
                        gridPanel.remove(obj.getSeccode());
                        gridPanel.remove(obj.getType());
                        gridPanel.remove(obj.getjCheckBox());
                        gridPanel.remove(obj.getDelta());
                        gridPanel.remove(obj.getTarget());
                        gridPanel.remove(obj.getEquity());
                        gridPanel.remove(edit);
                        gridPanel.remove(apply);
                        gridPanel.remove(del);
                        removeOrderLists(obj);
                        map.keySet().remove(del.getIdObject());
                        save(map);
                        frame.setVisible(false);
                        frame.setSize(frame.getWidth(), frame.getHeight() - 35);
                        frame.setVisible(true);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                        System.out.println(buyList);
                        System.out.println(sellList);
                        System.out.println(holdList);
                    }
                });
                gridPanel.add(apply);
                gridPanel.add(edit);
                gridPanel.add(del);
                frame.setVisible(false);
                frame.setSize(frame.getWidth(), frame.getHeight() + 35);
//                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        frame.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                save(map);
            }
        });
        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.add(lineState,BorderLayout.PAGE_END);
        lineState.setText("Buy: "+buyList+";"+"Sell: "+sellList+";"+"Hold: "+holdList);
        lineState.setEditable(false);
        lineState.setBackground(dark);
        lineState.setForeground(Color.white);
        frame.setVisible(false);
    }

    public synchronized void save(HashMap<Integer, DesktopObject> map) {
        try {
            FileOutputStream fos =
                    new FileOutputStream("hashmap.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(map);
            oos.close();
            fos.close();
            map.forEach((k, v) -> System.out.println("Item : " + k + " Object : " + v));
        } catch (Exception e) {
        }
    }

    private void initialize(JPanel gridPanel, JDialog frame) {
        try {
            FileInputStream fis = new FileInputStream("hashmap.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            map = (HashMap) ois.readObject();
            ois.close();
            fis.close();
            Iterator<Map.Entry<Integer, DesktopObject>> entries = map.entrySet().iterator();
//            PTextField name = new PTextField("nameTS");
//            PTextField account = new PTextField("account");
//            PTextField clientCode = new PTextField("clientCode");
//            PTextField secCode = new PTextField("codeQuik");
//            PTextField quantity = new PTextField("quantity");
//            PTextField delta = new PTextField("delta");
            while (entries.hasNext()) {
                Map.Entry<Integer, DesktopObject> entry = entries.next();
                DesktopObject object = entry.getValue();
                gridPanel.add(object.getName());
                gridPanel.add(object.getAccount());
                gridPanel.add(object.getClientCode());
                gridPanel.add(object.getSeccode());
                gridPanel.add(object.getType());
                gridPanel.add(object.getQuantity());
                gridPanel.add(object.getDelta());
                gridPanel.add(object.getjCheckBox());
                gridPanel.add(object.getTarget());
                gridPanel.add(object.getEquity());
//                object=new DesktopObject(
//                        name,account,clientCode,secCode,object.getType(),quantity,delta,object.getjCheckBox(),object.getIdObject(),object.getTarget(),object.getEquity(),object.getEq()
//                );
                addMouseListner(object, gridPanel, frame);
//                buyList = initOrderList()[0];
//                sellList = initOrderList()[1];
//                holdList = initOrderList()[2];
//                System.out.println(buyList);
//                System.out.println(sellList);
//                System.out.println(holdList);
                System.out.println(object.getEq().toString());
            }
            buyList = initOrderList()[0];
            sellList = initOrderList()[1];
            holdList = initOrderList()[2];
            frame.setSize(frame.getWidth(), frame.getHeight() + 35 * map.size());
        } catch (Exception e) {
        }
    }

    private void addMouseListner(DesktopObject object, JPanel gridPanel, JDialog frame) {
        MyButton apply = new MyButton(null, object.getIdObject());
        apply.setIcon(new ImageIcon("icon/icons8-save-20.png"));
        apply.setBackground(dark);
        apply.setForeground(Color.white);
        MyButton edit = new MyButton(null, object.getIdObject());
        edit.setIcon(new ImageIcon("icon/icons8-edit-20.png"));
        edit.setBackground(dark);
        edit.setForeground(Color.white);
        MyButton del = new MyButton(null, object.getIdObject());
        del.setIcon(new ImageIcon("icon/icons8-delete-20.png"));
        del.setBackground(dark);
        del.setForeground(Color.white);
        apply.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                object.getName().setEnabled(false);
                object.getAccount().setEnabled(false);
                object.getClientCode().setEnabled(false);
                object.getSeccode().setEnabled(false);
                object.getType().setEnabled(false);
                object.getQuantity().setEnabled(false);
                object.getDelta().setEnabled(false);
                object.getjCheckBox().setEnabled(false);
                object.getName().setBackground(Color.LIGHT_GRAY);
                object.getAccount().setBackground(Color.LIGHT_GRAY);
                object.getClientCode().setBackground(Color.LIGHT_GRAY);
                object.getSeccode().setBackground(Color.LIGHT_GRAY);
                object.getType().setBackground(Color.LIGHT_GRAY);
                object.getQuantity().setBackground(Color.LIGHT_GRAY);
                object.getDelta().setBackground(Color.LIGHT_GRAY);
                object.getTarget().setEnabled(false);
                object.getEquity();
                boolean status = object.getjCheckBox().isSelected();
                object.getjCheckBox().setBackground(status == true ? green : null);
                object.getjCheckBox().setOpaque(status == true ? true : false);
                map.put(apply.getIdObject(), object);
                writeCode(object.getType().getSelectedItem().toString());
                getPriceFromQuik();
                save(map);
                System.out.println(buyList);
                System.out.println(sellList);
                System.out.println(holdList);
            }
        });
        edit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                object.getName().setEnabled(true);
                object.getAccount().setEnabled(true);
                object.getClientCode().setEnabled(true);
                object.getSeccode().setEnabled(true);
                object.getType().setEnabled(true);
                object.getQuantity().setEnabled(true);
                object.getDelta().setEnabled(true);
                object.getjCheckBox().setEnabled(true);
                object.getTarget().setEnabled(true);
                object.getName().setBackground(Color.white);
                object.getAccount().setBackground(Color.white);
                object.getClientCode().setBackground(Color.white);
                object.getSeccode().setBackground(Color.white);
                object.getType().setBackground(Color.white);
                object.getQuantity().setBackground(Color.white);
                object.getDelta().setBackground(Color.white);
                object.getjCheckBox().setOpaque(false);
                boolean status = object.getjCheckBox().isSelected();
                object.getjCheckBox().setBackground(status == true ? green : col1);
            }
        });
        del.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DesktopObject obj = map.get(del.getIdObject());
                gridPanel.remove(obj.getName());
                gridPanel.remove(obj.getAccount());
                gridPanel.remove(obj.getName());
                gridPanel.remove(obj.getClientCode());
                gridPanel.remove(obj.getQuantity());
                gridPanel.remove(obj.getSeccode());
                gridPanel.remove(obj.getType());
                gridPanel.remove(obj.getjCheckBox());
                gridPanel.remove(obj.getDelta());
                gridPanel.remove(obj.getTarget());
                gridPanel.remove(obj.getEquity());
                gridPanel.remove(edit);
                gridPanel.remove(apply);
                gridPanel.remove(del);
                removeOrderLists(obj);
                map.keySet().remove(del.getIdObject());
                save(map);
                frame.setVisible(false);
                frame.setSize(frame.getWidth(), frame.getHeight() - 35);
                frame.setVisible(true);
                System.out.println(buyList);
                System.out.println(sellList);
                System.out.println(holdList);
            }
        });
        object.getTarget().setBackground(dark);
        object.getTarget().setForeground(Color.white);
        object.getjCheckBox().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (object.getjCheckBox().isSelected()) {
                    object.getjCheckBox().setBackground(green);
                    object.getjCheckBox().setText("ON");
                    object.getjCheckBox().setForeground(Color.white);
                } else {
                    object.getjCheckBox().setText("OFF");
                    object.getjCheckBox().setBackground(col1);
                    object.getjCheckBox().setForeground(Color.white);
                }
            }
        });
        object.getEquity().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    new LineChart1("EQ", object.getEq().getTotal()).create_graphics("EQ", object.getEq().getTotal());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        object.getType().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (object.getType().getSelectedItem().equals("SPBFUT")) {
                    object.getAccount().setText(dialog.getAccounttext());
                } else {
                    object.getAccount().setText(dialog.getAccounttext_2().getText());
                }
            }
        });
        object.getTarget().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (n == 0) {
                    n = 1;
                    object.getTarget().setLabel("All");
                    object.getTarget().setIcon(new ImageIcon("icon/icons8-all-20.png"));
                } else if (n == 1) {
                    n = 2;
                    object.getTarget().setLabel("Mail");
                    object.getTarget().setIcon(new ImageIcon("icon/icons8-mail-20.png"));
                } else if (n == 2) {
                    n = 0;
                    object.getTarget().setLabel("Quik");
                    object.getTarget().setIcon(new ImageIcon("icon/icons8-account-20.png"));
                }
            }
        });
        gridPanel.add(apply);
        gridPanel.add(edit);
        gridPanel.add(del);
    }

    public synchronized Map<String, String> getPriceFromQuik() {
        String[] str = null;
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new FileReader("quote.txt"));
            while (rd.ready()) {
                str = rd.readLine().split(":");
                infoPrice.put(str[0], str[1]);
            }
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return infoPrice;
    }

    private synchronized void writeCode(String type) {
        BufferedWriter writer = null;
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new FileReader(type.equals("SPBFUT")?"fut.txt":"stock.txt"));
            writer = new BufferedWriter(new FileWriter(type.equals("SPBFUT")?"fut.txt":"stock.txt", true));
            String str = rd.ready() ? rd.readLine() : " ";
            for (Map.Entry<Integer, DesktopObject> entry : map.entrySet()) {
                if (!str.contains(entry.getValue().getSeccode().getText())) {
                    writer.write(entry.getValue().getSeccode().getText() + ",");
                }
            }
            writer.flush();
            rd.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<Integer, DesktopObject> getMap() {
        return map;
    }

    public void setMap(HashMap<Integer, DesktopObject> map) {
        this.map = map;
    }

    public JDialog getFrame() {
        return frame;
    }

    public void setFrame(JDialog frame) {
        this.frame = frame;
    }

    private ArrayList<String>[] initOrderList() {
        ArrayList<String>[] list = new ArrayList[3];
        String[] path = {
                "buylist.ser",
                "selllist.ser",
                "holdlist.ser"
        };
        try {
            for (int i = 0; i < path.length; i++) {
                FileInputStream fis = new FileInputStream(path[i]);
                if (fis.available() > 0) {
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    list[i] = (ArrayList<String>) ois.readObject();
                    ois.close();
                }
                fis.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list[0] == null) {
            list[0] = new ArrayList<String>();
        }
        if (list[1] == null) {
            list[1] = new ArrayList<String>();
        }
        if (list[2] == null) {
            list[2] = new ArrayList<String>();
        }

        return list;
    }

    private void removeOrderLists(DesktopObject o) {
        try {
            buyList.remove(o.getName().getText());
            sellList.remove(o.getName().getText());
            holdList.remove(o.getName().getText());
        } catch (Exception e) {
        }
    }

    public ParserApplication.Dialog getDialog() {
        return dialog;
    }

    public void setDialog(ParserApplication.Dialog dialog) {
        this.dialog = dialog;
    }

    public String getLineState() {
        return lineState.getText();
    }

    public void setLineState(String lineState) {
        this.lineState.setText(lineState);
    }
}

