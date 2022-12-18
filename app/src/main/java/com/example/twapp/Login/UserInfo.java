package com.example.twapp.Login;

public class UserInfo {
    private static String account;
    private static String password;
    private static String name;
    private static String telephone;


    public static String getAccount() {
        return account;
    }

    public static String getPassword() {
        return password;
    }

    public static String getName() {
        return name;
    }

    public static String getTelephone() {
        return telephone;
    }

    public static void setAccount(String account) {
        UserInfo.account = account;
    }

    public static void setPassword(String password) {
        UserInfo.password = password;
    }

    public static void setName(String name) {
        UserInfo.name = name;
    }

    public static void setTelephone(String telephone) {
        UserInfo.telephone = telephone;
    }
}
