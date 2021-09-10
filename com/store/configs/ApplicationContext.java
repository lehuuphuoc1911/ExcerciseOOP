package com.store.configs;

import com.store.enteties.Cart;
import com.store.enteties.User;
import com.store.enteties.impl.DefaultCart;
import com.store.menu.Menu;

public class ApplicationContext {
    private static ApplicationContext instance;
    private User loggedInUser;
    private Menu mainMenu;
    private Cart sessionCart;
    private ApplicationContext(){}

    public void setLoggedInUser(User user){
        if (this.sessionCart != null){
            this.sessionCart.clear();
        }
        loggedInUser = user;
    }
    public User getLoggedInUser() {
        return loggedInUser;
    }

    public Menu getMainMenu() {
        return mainMenu;
    }

    public void setMainMenu(Menu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public static ApplicationContext getInstance() {
        if(instance == null){
            instance = new ApplicationContext();
        }
        return instance;
    }

    public Cart getSessionCart() {
        if(this.sessionCart==null){
            this.sessionCart = new DefaultCart();
        }
        return sessionCart;
    }
    public boolean isLoggedIn(){
        if (loggedInUser == null){
            return  false;
        } else {
            return true;
        }
    }
}
