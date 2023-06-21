package com.example.datingapp.auth;

import java.sql.Connection;

public class DBConnection {

    private DBConnection() { }

    // Returner Mysql connection objekt
    private static Connection connect() {
        return null;
    }

    // Lag en query som selecter brukeren med samme mail.
    public static boolean verifyUser(String email, String passw) {
        Connection conn = connect();

        return true;
    }

    // Query som registrerer en bruker
    public static boolean register(String email, String passw, String name, String age, String sex) {
        Connection conn = connect();

        return true;
    }

    // "liker" liker "liked"
    public static void like(User liker, User liked) {
        Connection conn = connect();
    }
}
