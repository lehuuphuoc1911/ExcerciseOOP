package com.store.menu.impl;

import com.store.configs.ApplicationContext;
import com.store.menu.Menu;
import com.store.services.impl.DefaultUserManagementService;

import java.util.Scanner;

public class ChangePasswordMenu implements Menu {
    private ApplicationContext context;
    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);
        System.out.print("Your current password: ");
        String userPassword;
        userPassword = sc.next();
        if (context.getLoggedInUser().getPassword().equals(userPassword)){
            System.out.print("Your new password: ");
            String newPassword = sc.next();
            context.getLoggedInUser().setPassword(newPassword);
            System.out.println("Your password has been change");
            context.getMainMenu().start();
        } else {
            System.out.println("Password is incorrect. Please try again.");
            new SettingMenu().start();
        }

    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** Change Password *****");
    }
}
