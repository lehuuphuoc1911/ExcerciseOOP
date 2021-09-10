package com.store.menu.impl;

import com.store.configs.ApplicationContext;
import com.store.enteties.Order;
import com.store.enteties.impl.DefaultOrder;
import com.store.menu.Menu;
import com.store.services.OrderManagementService;
import com.store.services.impl.DefaultOrderManagementService;

import java.util.Scanner;

public class CheckOutMenu implements Menu {
    private ApplicationContext context;
    private OrderManagementService orderManagementService;
    {
        context = ApplicationContext.getInstance();
        orderManagementService = DefaultOrderManagementService.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        while (true){
            System.out.print("Enter your credit card number (no space "+ DefaultOrder.CREDIT_CARD_NUMBER_LONG +" digits long) if you confirm purchase: ");
            System.out.print("Or enter `menu` to go to menu");
            Scanner sc = new Scanner(System.in);
            String userInput = sc.next();
            if (userInput == MainMenu.MENU_COMMAND){
                break;
            }
            if (!createOrder(userInput)) {
                System.out.println("Credit card number is invalid.");
                continue;
            }
            context.getSessionCart().clear();
            System.out.println("Your order has been confirmed. Congratulation!! Now you owe me some money :))");
            break;
        }
        context.getMainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** CHECKOUT *****");
        for (int i= 0; i< context.getSessionCart().getProducts().length;i++){
            System.out.println(context.getSessionCart().getProducts()[i].toString());
        }

    }

    private boolean createOrder(String creditCardNumber) {
        Order order = new DefaultOrder();
        if (!order.isCreditCardNumberValid(creditCardNumber)) {
            return false;
        }

        order.setCreditCardNumber(creditCardNumber);
        order.setProducts(context.getSessionCart().getProducts());
        order.setCustomerId(context.getLoggedInUser().getId());
        orderManagementService.addOrder(order);
        return true;
    }
}
