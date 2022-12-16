package com.example.twapp.Login;

public class UserData {
    private String account;
    private String password;
    private String name;
   private String telephone;

    public UserData(String account, String password, String name, String telephone) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }
}
