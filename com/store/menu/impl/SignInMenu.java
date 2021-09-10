package com.store.menu.impl;

import com.store.configs.ApplicationContext;
import com.store.enteties.User;
import com.store.menu.Menu;
import com.store.services.UserManagementService;
import com.store.services.impl.DefaultUserManagementService;

import java.util.Scanner;

public class SignInMenu implements Menu {
    private ApplicationContext context;
    private UserManagementService userManagementService;
    {
        context = ApplicationContext.getInstance();
        userManagementService = DefaultUserManagementService.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);
        System.out.print("Please, enter your email: ");
        String userEmail = sc.next();

        System.out.print("Please, enter your password: ");
        String userPassword = sc.next();

        User user = userManagementService.getUserByEmail(userEmail);
        if (user == null){
            System.out.println("Email do not exit");
            System.out.println();
            return;
        }
        if (user.getPassword().equals(userPassword)){
            System.out.println("Log in success. Hello "+user.getFirstName()+" "+user.getLastName());
            context.setLoggedInUser(user);
        } else {
            System.out.println("Password is incorrect");
        }
        context.getMainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** Sign In *****");
    }
}
