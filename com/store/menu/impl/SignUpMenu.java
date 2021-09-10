package com.store.menu.impl;

import com.store.configs.ApplicationContext;
import com.store.enteties.User;
import com.store.enteties.impl.DefaultUser;
import com.store.menu.Menu;
import com.store.services.UserManagementService;
import com.store.services.impl.DefaultUserManagementService;

import java.util.Scanner;

public class SignUpMenu implements Menu {
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
        System.out.print("Please, enter your first name: ");
        String firstName = sc.next();
        System.out.print("Please, enter your last name: ");
        String lastName = sc.next();
        System.out.print("Please, enter your password: ");
        String password = sc.next();
        System.out.print("Please, enter your email: ");
        sc = new Scanner(System.in);
        String email = sc.nextLine();
        User user = new DefaultUser(firstName, lastName, password, email);
        String errorMessage = userManagementService.registerUser(user);
        if (errorMessage == DefaultUserManagementService.NO_ERROR_MESSAGE) {
            context.setLoggedInUser(user);
            System.out.println("New user is created");
        } else {
            System.out.println(errorMessage);
        }

        context.getMainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** SIGN UP *****");
    }
}
