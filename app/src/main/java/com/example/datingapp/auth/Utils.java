package com.example.datingapp.auth;

public class Utils {

    private static User currentUser;

    private Utils() { }

    public static void setCurrentUser(User currentUser) {
        Utils.currentUser = currentUser;
    }

    public static User getCurrentUser() {
        return currentUser;
    }
}
