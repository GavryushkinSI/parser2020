package ru.gavryushkin.parser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CustomWebHooksModule {
    private volatile Map<String, String> infoPrice = new HashMap<>();
    private volatile HashMap<Integer, DesktopObject> map;
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
    private ParserApplication.WebHooksModule wb;
    private JTextField lineState;
    private JComboBox nameTs;

    public CustomWebHooksModule(ParserApplication.Dialog dialog, ParserApplication.WebHooksModule wb) {
        this.dialog = dialog;
        this.wb = wb;
    }

    public void init() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        frame = new JDialog(ParserApplication.frame, "CUSTOM WEBHOOKS MODULE");
        frame.setIconImage(new ImageIcon("icon/icons8-webhook-22.png").getImage());
        frame.setBounds(300, 300, 1420, 100);
        JButton button = new JButton("ADD STRATEGY", new ImageIcon("icon/icons8-add-20.png"));
        button.setToolTipText("Добавить стратегию");
        JButton buyBtn = new JButton("BUY");
        buyBtn.setBackground(green);
        JButton sellBtn = new JButton("SELL");
        sellBtn.setBackground(red);
        button.setBackground(blueDark);
        button.setForeground(Color.white);
        JPanel panelBtn = new JPanel();
        panelBtn.setLayout(new FlowLayout());
        panelBtn.add(button);
        panelBtn.add(buyBtn);
        panelBtn.add(sellBtn);
        panelBtn.setBackground(dark);
        frame.add(panelBtn, BorderLayout.NORTH);
        lineState = new JTextField();
        JPanel panel = new JPanel(new BorderLayout());
        GridLayout gridLayout = new GridLayout(0, 17);
        JPanel gridPanel = new JPanel(gridLayout);
        initialize(gridPanel, frame);
        if (map == null) {
            map = new HashMap<>();
        }

        nameTs = new JComboBox<String>();
        buyBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DesktopObject obj = getDetails((String) nameTs.getSelectedItem(), getMap());
                String oldQuantity = obj.getQty();
                if (obj.getType().getSelectedItem().toString().equals("IB")) {
                    obj.setQty("1");
                    wb.buyWebHookIb(obj, 0, null);
                    obj.setQty(oldQuantity);
                } else {
                    obj.setQty("1");
                    wb.buyWebHook(obj, null, 0, getPriceFromQuik());
                    obj.setQty(oldQuantity);
                }
            }
        });
        buyBtn.setForeground(Color.WHITE);
        sellBtn.setForeground(Color.WHITE);
        sellBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DesktopObject obj = getDetails((String) nameTs.getSelectedItem(), getMap());
                String oldQuantity = obj.getQty();
                if (obj.getType().getSelectedItem().toString().equals("IB")) {
                    obj.setQty("1");
                    wb.sellWebHookIb(obj, 0, null);
                    obj.setQty(oldQuantity);
                } else {
                    obj.setQty("1");
                    wb.sellWebHook(null, 0, obj, getPriceFromQuik());
                    obj.setQty(oldQuantity);
                }
            }
        });
        nameTs.setPreferredSize(new Dimension(120, 30));
        nameTs.setToolTipText("Наименование стратегии " +
                "в рамках которой нужно выставить ручную заявку");
        panelBtn.add(nameTs);
        System.out.println(map.size());
        idObject = map.size();
        JScrollPane screenScroll = new JScrollPane(gridPanel);
        panel.add(screenScroll);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PTextField name = new PTextField("nameTS");
                PTextField account = new PTextField("account");
                account.setToolTipText("Номер счёта");
                account.setText(dialog.getAccounttext());
                account.setForeground(Color.black);
                PTextField clientCode = new PTextField("clientCode");
                clientCode.setToolTipText("Код клиента");
                clientCode.setForeground(Color.black);
                clientCode.setText(dialog.getClientcodetext());
                PTextField secCode = new PTextField("symbol");
                secCode.setToolTipText("Код инструмента");
                JComboBox type = new JComboBox(new String[]{"SPBFUT", "TQBR", "XBTUSD", "IB"});
                PTextField quantity = new PTextField("quantity");
                quantity.setToolTipText("Количество лотов в заявке");
                PTextField delta = new PTextField("delta");
                delta.setToolTipText("Размер проскальзывания, для рынка акций значение всегда равно 0");
                PTextField contractId = new PTextField("contractId");
                contractId.setToolTipText("Уникальный идентификатор инструмента");
                PTextField exchange = new PTextField("exchange");
                exchange.setToolTipText("Наименование биржи");
                PTextField localSymbol = new PTextField("localSymbol");
                localSymbol.setToolTipText("Уточнённый код инструмента");
                PTextField secType = new PTextField("secType");
                secType.setToolTipText("Тип инструмента (акции, фьючерсы...");
                JButton equity = new JButton("EQ", new ImageIcon("icon/icons8-graph-20.png"));
                equity.setBackground(dark);
                equity.setForeground(Color.white);
                JToggleButton jCheckBox = new JToggleButton("OFF");
                jCheckBox.setSelected(false);
                jCheckBox.setBackground(col1);
                jCheckBox.setForeground(Color.white);
                JButton target = new JButton("All", new ImageIcon("icon/icons8-all-20.png"));
                DesktopObject object = new DesktopObject(name, account, clientCode, secCode, type,
                        quantity, delta, jCheckBox, idObject++,
                        target, equity, new Graph(), exchange, contractId, localSymbol, secType);
                type.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        checkType(object, red);
                    }
                });
                equity.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            new LineChart1("EQ " + object.getName().getText(), object.getEq().getTotal()).create_graphics("EQ", object.getEq().getTotal());
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
                gridPanel.add(object.getContractID());
                gridPanel.add(object.getExchange());
                gridPanel.add(object.getLocalSymbol());
                gridPanel.add(object.getSecType());
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
                        contractId.setEnabled(false);
                        exchange.setEnabled(false);
                        secType.setEnabled(false);
                        localSymbol.setEnabled(false);
                        jCheckBox.setEnabled(false);
                        target.setEnabled(false);
                        name.setBackground(Color.LIGHT_GRAY);
                        account.setBackground(Color.LIGHT_GRAY);
                        clientCode.setBackground(Color.LIGHT_GRAY);
                        secCode.setBackground(Color.LIGHT_GRAY);
                        type.setBackground(Color.LIGHT_GRAY);
                        quantity.setBackground(Color.LIGHT_GRAY);
                        delta.setBackground(Color.LIGHT_GRAY);
                        contractId.setBackground(Color.LIGHT_GRAY);
                        exchange.setBackground(Color.LIGHT_GRAY);
                        secType.setBackground(Color.LIGHT_GRAY);
                        localSymbol.setBackground(Color.LIGHT_GRAY);
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
                        checkType(object, Color.lightGray);
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
                        contractId.setEnabled(true);
                        exchange.setEnabled(true);
                        secType.setEnabled(true);
                        localSymbol.setEnabled(true);
                        name.setBackground(Color.white);
                        account.setBackground(Color.white);
                        clientCode.setBackground(Color.white);
                        secCode.setBackground(Color.white);
                        type.setBackground(Color.white);
                        quantity.setBackground(Color.white);
                        delta.setBackground(Color.white);
                        contractId.setBackground(Color.white);
                        exchange.setBackground(Color.white);
                        secType.setBackground(Color.white);
                        localSymbol.setBackground(Color.white);
                        boolean status = jCheckBox.isSelected();
                        jCheckBox.setBackground(status == true ? green : col1);
                        jCheckBox.setOpaque(false);
                        checkType(object, red);
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
                        gridPanel.remove(obj.getContractID());
                        gridPanel.remove(obj.getExchange());
                        gridPanel.remove(obj.getLocalSymbol());
                        gridPanel.remove(obj.getSecType());
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
                checkType(object, red);
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
        frame.add(lineState, BorderLayout.PAGE_END);
        lineState.setText("Buy: " + buyList + ";" + "Sell: " + sellList + ";" + "Hold: " + holdList);
        lineState.setEditable(false);
        lineState.setBackground(dark);
        lineState.setForeground(Color.white);
        frame.setVisible(false);
        save(map);
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
//            map.forEach((k, v) -> setBorder(true, v, Color.lightGray));
            nameTs.setModel(new DefaultComboBoxModel(getSetNameTs(getMap()).toArray(new String[getSetNameTs(getMap()).size()])));
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
                gridPanel.add(object.getContractID());
                gridPanel.add(object.getExchange());
                gridPanel.add(object.getLocalSymbol());
                gridPanel.add(object.getSecType());
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
                object.getExchange().setEnabled(false);
                object.getContractID().setEnabled(false);
                object.getSecType().setEnabled(false);
                object.getLocalSymbol().setEnabled(false);
                object.getName().setBackground(Color.LIGHT_GRAY);
                object.getAccount().setBackground(Color.LIGHT_GRAY);
                object.getClientCode().setBackground(Color.LIGHT_GRAY);
                object.getSeccode().setBackground(Color.LIGHT_GRAY);
                object.getType().setBackground(Color.LIGHT_GRAY);
                object.getQuantity().setBackground(Color.LIGHT_GRAY);
                object.getDelta().setBackground(Color.LIGHT_GRAY);
                object.getExchange().setBackground(Color.LIGHT_GRAY);
                object.getContractID().setBackground(Color.LIGHT_GRAY);
                object.getLocalSymbol().setBackground(Color.LIGHT_GRAY);
                object.getSecType().setBackground(Color.LIGHT_GRAY);
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
                checkType(object, Color.lightGray);
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
                object.getExchange().setEnabled(true);
                object.getContractID().setEnabled(true);
                object.getSecType().setEnabled(true);
                object.getLocalSymbol().setEnabled(true);
                object.getName().setBackground(Color.white);
                object.getAccount().setBackground(Color.white);
                object.getClientCode().setBackground(Color.white);
                object.getSeccode().setBackground(Color.white);
                object.getType().setBackground(Color.white);
                object.getQuantity().setBackground(Color.white);
                object.getDelta().setBackground(Color.white);
                object.getExchange().setBackground(Color.white);
                object.getContractID().setBackground(Color.white);
                object.getSecType().setBackground(Color.white);
                object.getLocalSymbol().setBackground(Color.white);
                object.getjCheckBox().setOpaque(false);
                boolean status = object.getjCheckBox().isSelected();
                object.getjCheckBox().setBackground(status == true ? green : col1);
                checkType(object, red);
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
                gridPanel.remove(obj.getExchange());
                gridPanel.remove(obj.getSecType());
                gridPanel.remove(obj.getLocalSymbol());
                gridPanel.remove(obj.getContractID());
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
                    new LineChart1("EQ " + object.getName().getText(), object.getEq().getTotal()).create_graphics("EQ", object.getEq().getTotal());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        object.getType().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                checkType(object, red);
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
        setBorder(true, object, Color.lightGray);
    }

    public synchronized Map<String, String> getPriceFromQuik() {
        String[] str = null;
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new FileReader("quote.txt"));
            while (rd.ready()) {
                str = rd.readLine().split(":");
                if (!str[1].equals("0") || !str[1].equals(" ") || !str[1].equals("")) {
                    infoPrice.put(str[0], str[1]);
                }
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
            rd = new BufferedReader(new FileReader(type.equals("SPBFUT") ? "fut.txt" : "stock.txt"));
            writer = new BufferedWriter(new FileWriter(type.equals("SPBFUT") ? "fut.txt" : "stock.txt", true));
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

    public DesktopObject getDetails(String nameTs, HashMap<Integer, DesktopObject> objectHashMap) {
        for (Map.Entry<Integer, DesktopObject> entry : objectHashMap.entrySet()) {
            if (entry.getValue().getName().getText().equals(nameTs)) {
                return entry.getValue();
            }

        }
        return null;
    }

    private Set<String> getSetNameTs(HashMap<Integer, DesktopObject> objectHashMap) {
        Set<String> nameTsSet = new HashSet<>(objectHashMap.size());
        for (Map.Entry<Integer, DesktopObject> entry : objectHashMap.entrySet()) {
            nameTsSet.add(entry.getValue().getName().getText());
        }
        return nameTsSet;
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

    public void checkType(DesktopObject object, Color color) {
        setBorder(true, object, color);
        if (object.getType().getSelectedItem().equals("SPBFUT")) {
            object.getAccount().setText(dialog.getAccounttext());
            object.getAccount().setEnabled(true);
            object.getDelta().setEnabled(true);
            object.getSeccode().setEnabled(true);
            object.getClientCode().setEnabled(true);
            object.getExchange().setEnabled(false);
            object.getContractID().setEnabled(false);
            object.getSecType().setEnabled(false);
            object.getLocalSymbol().setEnabled(false);
        } else if (object.getType().getSelectedItem().equals("TQBR")) {
            object.getAccount().setText(dialog.getAccounttext_2().getText());
            object.getAccount().setEnabled(true);
            object.getDelta().setEnabled(false);
            object.getSeccode().setEnabled(true);
            object.getClientCode().setEnabled(true);
            object.getExchange().setEnabled(false);
            object.getContractID().setEnabled(false);
            object.getSecType().setEnabled(false);
            object.getLocalSymbol().setEnabled(false);
        } else if (object.getType().getSelectedItem().equals("XBTUSD")) {
            object.getAccount().setEnabled(false);
            object.getDelta().setEnabled(false);
            object.getSeccode().setEnabled(false);
            object.getClientCode().setEnabled(false);
            object.getExchange().setEnabled(false);
            object.getContractID().setEnabled(false);
            object.getSecType().setEnabled(false);
            object.getLocalSymbol().setEnabled(false);
        } else if ((object.getType().getSelectedItem().equals("IB"))) {
            object.getAccount().setEnabled(false);
            object.getClientCode().setEnabled(false);
            object.getSeccode().setEnabled(true);
            object.getDelta().setEnabled(false);
            object.getExchange().setEnabled(true);
            object.getContractID().setEnabled(true);
            object.getSecType().setEnabled(true);
            object.getLocalSymbol().setEnabled(true);
        }
    }

    private void setBorder(boolean use, DesktopObject object, Color color) {
        if (object.getType().getSelectedItem().equals("SPBFUT")) {
            object.getName().setBorder(BorderFactory.createLineBorder(color, 2));
            object.getAccount().setBorder(BorderFactory.createLineBorder(color, 2));
            object.getClientCode().setBorder(BorderFactory.createLineBorder(color, 2));
            object.getDelta().setBorder(BorderFactory.createLineBorder(color, 2));
            object.getSeccode().setBorder(BorderFactory.createLineBorder(color, 2));
            object.getType().setBorder(BorderFactory.createLineBorder(color, 2));
            object.getQuantity().setBorder(BorderFactory.createLineBorder(color, 2));
            object.getExchange().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
            object.getContractID().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
            object.getSecType().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
            object.getLocalSymbol().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
        } else if (object.getType().getSelectedItem().equals("TQBR")) {
            object.getName().setBorder(BorderFactory.createLineBorder(color, 2));
            object.getAccount().setBorder(BorderFactory.createLineBorder(color, 2));
            object.getClientCode().setBorder(BorderFactory.createLineBorder(color, 2));
            object.getDelta().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
            object.getSeccode().setBorder(BorderFactory.createLineBorder(color, 2));
            object.getType().setBorder(BorderFactory.createLineBorder(color, 2));
            object.getQuantity().setBorder(BorderFactory.createLineBorder(color, 2));
            object.getExchange().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
            object.getContractID().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
            object.getSecType().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
            object.getLocalSymbol().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
        } else if (object.getType().getSelectedItem().equals("XBTUSD")) {
            object.getName().setBorder(BorderFactory.createLineBorder(color, 2));
            object.getAccount().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
            object.getClientCode().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
            object.getDelta().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
            object.getSeccode().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
            object.getType().setBorder(BorderFactory.createLineBorder(color, 2));
            object.getQuantity().setBorder(BorderFactory.createLineBorder(color, 2));
            object.getExchange().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
            object.getContractID().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
            object.getSecType().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
            object.getLocalSymbol().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
        } else if ((object.getType().getSelectedItem().equals("IB"))) {
            object.getName().setBorder(BorderFactory.createLineBorder(color, 2));
            object.getAccount().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
            object.getClientCode().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
            object.getDelta().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
            object.getSeccode().setBorder(BorderFactory.createLineBorder(color, 2));
            object.getType().setBorder(BorderFactory.createLineBorder(color, 2));
            object.getQuantity().setBorder(BorderFactory.createLineBorder(color, 2));
            object.getExchange().setBorder(BorderFactory.createLineBorder(color, 2));
            object.getContractID().setBorder(BorderFactory.createLineBorder(color, 2));
            object.getSecType().setBorder(BorderFactory.createLineBorder(color, 2));
            object.getLocalSymbol().setBorder(BorderFactory.createLineBorder(color, 2));
        }
    }
}

