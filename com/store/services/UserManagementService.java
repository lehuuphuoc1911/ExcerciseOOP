package com.store.services;

import com.store.enteties.User;

public interface UserManagementService {
    String registerUser(User user);
    User[] getUsers();
    User getUserByEmail(String userEmail);
    int getLastUserIndex();
    public String checkUniqueEmail(String email);
}
