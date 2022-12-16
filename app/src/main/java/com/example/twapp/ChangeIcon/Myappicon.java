package com.example.twapp.ChangeIcon;

import android.app.Application;

public class Myappicon extends Application {
    private String name="no login";
    private String account;
    private String Telephone;
    @Override
    public void onCreate() {
        super.onCreate();
        Foregroundback.init(this);
    }

    public String getName() {
        return name;
    }

    public String getAccount() {
        return account;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }
}
