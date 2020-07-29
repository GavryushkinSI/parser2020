package ru.gavryushkin.parser.interactivebroker;

import com.ib.client.Contract;
import com.ib.client.Order;
import com.ib.client.OrderState;

public class CompletedOrder {
    Contract m_contract;
    Order m_order;
    OrderState m_orderState;

    CompletedOrder(Contract contract, Order order, OrderState orderState) {
        m_contract = contract;
        m_order = order;
        m_orderState = orderState;
    }
}
