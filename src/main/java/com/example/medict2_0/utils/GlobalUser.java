package com.example.medict2_0.utils;

public class GlobalUser {
    private static String userId;

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        GlobalUser.userId = userId;
    }

}

