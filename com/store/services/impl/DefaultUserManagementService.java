package com.store.services.impl;

import com.store.enteties.User;
import com.store.services.UserManagementService;

import java.util.Arrays;
import java.util.Objects;

public class DefaultUserManagementService implements UserManagementService {
    private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
    private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
    public static final String NO_ERROR_MESSAGE = "SUCCESS";
    private static final int DEFAULT_USERS_CAPACITY = 10;
    public static  DefaultUserManagementService instance;
    private User[] users;
    public static UserManagementService getInstance(){
        if (instance==null){
            instance =  new DefaultUserManagementService();
        }
        return instance;
    }
    {
        users = new User[DEFAULT_USERS_CAPACITY];
    }
    public int lastUserIndex;
    @Override
    public String registerUser(User user) {

        String errorMessage = checkUniqueEmail(user.getEmail());
        if (errorMessage != NO_ERROR_MESSAGE ) {
            return errorMessage;
        }
        if (users.length <= lastUserIndex) {
            users = Arrays.copyOf(users, users.length + 1);
        }
        users[lastUserIndex++] = user;
        return NO_ERROR_MESSAGE;
    }
    @Override
    public String checkUniqueEmail(String email) {
        if (email == null || email.isEmpty()) {
            return EMPTY_EMAIL_ERROR_MESSAGE;
        }
        if (users == null){
            return NO_ERROR_MESSAGE;
        }
        for (User user : users) {
            if (user != null &&
                    user.getEmail() != null &&
                    user.getEmail().equalsIgnoreCase(email)) {
                return NOT_UNIQUE_EMAIL_ERROR_MESSAGE;
            }
        }
        return NO_ERROR_MESSAGE;
    }

    @Override
    public User[] getUsers() {
        /*return Arrays.stream(users)
				.filter(Objects::nonNull)
				.toArray(User[]::new);*/
        return users;
    }

    @Override
    public User getUserByEmail(String userEmail) {
        if (users == null){
            return null;
        }
        for (User user : users) {
            if (user != null && user.getEmail().equalsIgnoreCase(userEmail)) {
                return user;
            }
        }
        return null;
    }

    void clearServiceState() {
        lastUserIndex = 0;
        users = new User[DEFAULT_USERS_CAPACITY];
    }

    public int getLastUserIndex() {
        return lastUserIndex;
    }
}
