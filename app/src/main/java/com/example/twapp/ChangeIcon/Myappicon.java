package com.example.twapp.ChangeIcon;

import android.app.Application;
import android.widget.Toast;

import com.example.twapp.Login.Logins;
import com.example.twapp.MainActivity;
import com.example.twapp.Observer.Observer;
import com.example.twapp.Observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class Myappicon extends Application implements Subject {
    private String name="no login";
    private String account;
    private String Telephone;
    private List<Observer> observers;
    @Override
    public void onCreate() {
        super.onCreate();
        Foregroundback.init(this);
        observers=new ArrayList<Observer>();
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
        notifyObservers();
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer obj:observers
             ) {
            obj.update();

        }

    }
}
