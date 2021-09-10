package com.store.menu.impl;

import com.store.configs.ApplicationContext;
import com.store.menu.Menu;

public class SignOutMenu implements Menu {
    private ApplicationContext context;
    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        context.setLoggedInUser(null);
        context.getMainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** Sign Out *****");
    }
}
