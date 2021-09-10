package com.store.menu.impl;

import com.store.configs.ApplicationContext;
import com.store.menu.Menu;
import com.store.services.UserManagementService;
import com.store.services.impl.DefaultUserManagementService;

import java.util.Scanner;

public class ChangeEmailMenu implements Menu {
    private UserManagementService userManagementService;
    private ApplicationContext context;
    {
        context= ApplicationContext.getInstance();
        userManagementService = DefaultUserManagementService.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);
        System.out.print("Your new email: ");
        String newEmail;
        newEmail = sc.next();
        if (userManagementService.checkUniqueEmail(newEmail)!= DefaultUserManagementService.NO_ERROR_MESSAGE){
            System.out.println("Email is already used. Please try again.");
            new SettingMenu().start();
            return;
        }

        System.out.print("Your password: ");
        String userPassword;
        userPassword = sc.next();
        if (context.getLoggedInUser().getPassword().equals(userPassword)){
            context.getLoggedInUser().setEmail(newEmail);
            System.out.println("Your email is changed to "+ context.getLoggedInUser().getEmail());
        } else {
            System.out.println("Password is incorrect. Please try again.");
        }
        context.getMainMenu().start();

    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** Change Email *****");
    }
}
