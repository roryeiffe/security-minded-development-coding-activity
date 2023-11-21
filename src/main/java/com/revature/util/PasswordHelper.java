package com.revature.util;

public class PasswordHelper {
    public static boolean isPasswordValid(String password) {
        // check if password is long enough and contains special characters
        return password.length() >= 8 && password.matches(".*[!@#$%^&*].*");
    }
}
