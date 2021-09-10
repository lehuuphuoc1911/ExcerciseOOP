package com.store.menu.impl;

import com.store.configs.ApplicationContext;
import com.store.enteties.Order;
import com.store.menu.Menu;
import com.store.services.OrderManagementService;
import com.store.services.impl.DefaultOrderManagementService;

public class MyOrdersMenu implements Menu {
    private ApplicationContext context;
    private OrderManagementService orderManagementService;
    {
        context = ApplicationContext.getInstance();
        orderManagementService = DefaultOrderManagementService.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        if (context.getLoggedInUser() == null) {
            System.out.println("You have not logged in yet");
        } else {
            printUserOrdersToConsole();
        }
        new MainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** MY ORDERS *****");
    }
    private void printUserOrdersToConsole() {
        Order[] loggedInUserOrders = orderManagementService.getOrderByUserId(context.getLoggedInUser().getId());

        if (loggedInUserOrders == null || loggedInUserOrders.length == 0) {
            System.out.println(
                    "You don’t have any orders yet. Go back to main menu to place a new order");
        } else {
            for (Order order : loggedInUserOrders) {
                System.out.println(order);
            }
        }
    }
}
