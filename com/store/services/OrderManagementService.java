package com.store.services;

import com.store.enteties.Order;

public interface OrderManagementService {
    void addOrder(Order order);
    Order[] getOrderByUserId(int userId);
    Order[] getOrder();
}
