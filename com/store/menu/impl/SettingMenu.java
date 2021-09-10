package com.store.menu.impl;

import com.store.configs.ApplicationContext;
import com.store.menu.Menu;

import java.util.Scanner;

public class SettingMenu implements Menu {
    private static final String SETTINGS = "1. Change Password" + System.lineSeparator()
            + "2. Change Email"+ System.lineSeparator() + "3. Main Menu"+ System.lineSeparator() + "4. Exit";

    private ApplicationContext context;
    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        if (context.getLoggedInUser() == null){
            System.out.println("You have not logged in yet.");
            new MainMenu().start();
            return;
        }
        System.out.println("Command: ");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.next();
        Menu gotoMenu = null;
        switch (userInput){
            case "1":
                gotoMenu = new ChangePasswordMenu();
                break;
            case "2":
                gotoMenu = new ChangeEmailMenu();
                break;
            case "3":
                gotoMenu = new MainMenu();
                break;
            case "4":
                System.exit(0);
            default:
                System.out.println("Only 1, 2 is allowed. Try one more time");
                gotoMenu = this;
        }
        gotoMenu.start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** Setting *****");
        System.out.println(SETTINGS);
    }
}
