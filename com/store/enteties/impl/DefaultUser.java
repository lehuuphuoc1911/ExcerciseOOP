package com.store.enteties.impl;

import com.store.enteties.User;

public class DefaultUser implements User {
    public static int usercounter = 0;
    private int id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    {
        id = ++ usercounter;
    }

    public DefaultUser(){
    }
    public DefaultUser(String firstName, String lastName, String password, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        if (password == null){
            return;
        }
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        if (this.email == null){
            return;
        }
        this.email = email;
    }
    @Override
    public  String toString(){
        return "First Name: " + this.getFirstName() + "\t\t" +
                "Last Name: " + this.getLastName() + "\t\t" +
                "Email: " + this.getEmail();
    }
}
