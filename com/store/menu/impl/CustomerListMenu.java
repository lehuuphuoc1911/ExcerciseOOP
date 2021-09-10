package com.store.menu.impl;

import com.store.configs.ApplicationContext;
import com.store.enteties.User;
import com.store.menu.Menu;
import com.store.services.UserManagementService;
import com.store.services.impl.DefaultUserManagementService;

public class CustomerListMenu implements Menu {
    private ApplicationContext context;
    private UserManagementService userManagementService;
    {
        context = ApplicationContext.getInstance();
        userManagementService = DefaultUserManagementService.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        User[] users = userManagementService.getUsers();

        if (users.length == 0) {
            System.out.println("Unfortunately, there are no customers.");
        } else {
            for (User user : users) {
                if (user!= null) {
                    System.out.println(user);
                }
            }
        }
        context.getMainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** USERS *****");
    }
}
