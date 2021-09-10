package com.store.menu.impl;

import com.store.Main;
import com.store.configs.ApplicationContext;
import com.store.menu.Menu;

import java.util.Scanner;

public class MainMenu implements Menu {
    private ApplicationContext context;
    {
        context = ApplicationContext.getInstance();
    }
    public static final String MENU_COMMAND = "menu";
    private static final String MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER = "Please, enter number in console to proceed." + System.lineSeparator()
            + "1. Sign Up" + System.lineSeparator() + "2. Sign In"
            + System.lineSeparator() + "3. Product Catalog" + System.lineSeparator()
            + "4. My Orders" + System.lineSeparator() + "5. Settings" + System.lineSeparator() +
            "6. Customer List";

    private static final String MAIN_MENU_TEXT_FOR_LOGGED_IN_USER = "Please, enter number in console to proceed." + System.lineSeparator()
            + "1. Sign Up" + System.lineSeparator() + "2. Sign Out"
            + System.lineSeparator() + "3. Product Catalog" + System.lineSeparator()
            + "4. My Orders" + System.lineSeparator() + "5. Settings" + System.lineSeparator() +
            "6. Customer List";

    @Override
    public void start() {
        if (context.getMainMenu() == null){
            context.setMainMenu(this);
        }
        Menu gotoMenu = null;
        mainLoop: while (true){
            printMenuHeader();
            Scanner sc = new Scanner(System.in);
            System.out.println("Command: ");
            String userInput = sc.next();
            if (userInput.equalsIgnoreCase(Main.EXIT_COMMAND)){
                System.exit(0);
            } else {

                switch (userInput){
                    case "1":
                        gotoMenu = new SignUpMenu();
                        break mainLoop;
                    case "2":
                        if (context.isLoggedIn()){
                            gotoMenu = new SignOutMenu();
                        } else {
                            gotoMenu = new SignInMenu();
                        }
                        break mainLoop;
                    case "3":
                        gotoMenu = new ProductCatalogMenu();
                        break mainLoop;
                    case "4":
                        gotoMenu = new MyOrdersMenu();
                        break mainLoop;
                    case "5":
                        gotoMenu = new SettingMenu();
                        break mainLoop;
                    case "6":
                        gotoMenu = new CustomerListMenu();
                        break mainLoop;
                    default:
                        System.out.println("Only 1, 2, 3, 4, 5, 6 are allowed. Try one more time");
                        continue;
                }
            }
        }
        gotoMenu.start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("-----Main Menu-----");
        if (context.isLoggedIn()){
            System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_IN_USER);
        } else {
            System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER);
        }
    }
}
