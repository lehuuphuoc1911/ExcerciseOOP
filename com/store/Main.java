package com.store;

import com.store.menu.Menu;
import com.store.menu.impl.MainMenu;

public class Main {
    public static final String EXIT_COMMAND = "exit";

    public static void main(String[] args) {
        Menu mainMenu = new MainMenu();
        mainMenu.start();

    }
}
