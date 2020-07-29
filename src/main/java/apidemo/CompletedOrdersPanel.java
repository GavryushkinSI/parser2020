/* Copyright (C) 2019 Interactive Brokers LLC. All rights reserved. This code is subject to the terms
 * and conditions of the IB API Non-Commercial License or the IB API Commercial License, as applicable. */

package apidemo;

import apidemo.util.HtmlButton;
import com.ib.client.Contract;
import com.ib.client.Order;
import com.ib.client.OrderState;
import com.ib.controller.ApiController.ICompletedOrdersHandler;
import ru.gavryushkin.parser.ParserApplication;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CompletedOrdersPanel extends JPanel implements ICompletedOrdersHandler {
    private List<CompletedOrder> m_completedOrders = new ArrayList<>();
    private Model m_model = new Model();

    public CompletedOrdersPanel() {
        JTable table = new JTable(m_model);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBorder(new TitledBorder("Completed Orders"));

        HtmlButton but = new HtmlButton("Refresh") {
            @Override public void actionPerformed() {
                onRefresh();
            }
        };

        JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p.add(but);

        setLayout(new BorderLayout());
        add(scroll);
        add(p, BorderLayout.SOUTH);
    }

    public void activated() {
        onRefresh();
    }

    private void onRefresh() {
        m_completedOrders.clear();
        ParserApplication.ibConnector.controller().reqCompletedOrders(this);
    }

    private class Model extends AbstractTableModel {
        @Override public int getRowCount() {
            return m_completedOrders.size();
        }

        @Override public int getColumnCount() {
            return 9;
        }

        @Override public String getColumnName(int col) {
            switch( col) {
                case 0: return "Perm ID";
                //case 1: return "Parent Perm ID";
                //case 2: return "Account";
                case 1: return "Action";
                case 2: return "Quantity";
                //case 5: return "Cash Qty";
                case 3: return "Filled Qty";
                case 4: return "Lmt Price";
                case 5: return "Aux Price";
                case 6: return "Contract";
                case 7: return "Status";
                case 8: return "Completed Time";
                case 9: return "Completed Status";

                default: return null;
            }
        }

        @Override public Object getValueAt(int row, int col) {
            CompletedOrder completedOrder = m_completedOrders.get( row);
            switch( col) {
                case 0: return completedOrder.m_order.permId();
                //case 1: return Util.LongMaxString(completedOrder.m_order.parentPermId());
                //case 2: return completedOrder.m_order.account();
                case 1: return completedOrder.m_order.action();
                case 2: return completedOrder.m_order.totalQuantity();
                //case 5: return completedOrder.m_order.cashQty();
                case 3: return completedOrder.m_order.filledQuantity();
                case 4: return completedOrder.m_order.lmtPrice();
                case 5: return completedOrder.m_order.auxPrice();
                case 6: return completedOrder.m_contract.description();
                case 7: return completedOrder.m_orderState.status();
                case 8: return completedOrder.m_orderState.completedTime();
                case 9: return completedOrder.m_orderState.completedStatus();
                default: return null;
            }
        }
    }

    public static class CompletedOrder {
        Contract m_contract;
        Order m_order;
        OrderState m_orderState;

        CompletedOrder(Contract contract, Order order, OrderState orderState) {
            m_contract = contract;
            m_order = order;
            m_orderState = orderState;
        }
    }

    @Override
    public void completedOrder(Contract contract, Order order, OrderState orderState) {
        CompletedOrder completedOrder = new CompletedOrder(contract, order, orderState);
        m_completedOrders.add(completedOrder);
        m_model.fireTableDataChanged();
    }

    @Override
    public void completedOrdersEnd() {
    }
}
