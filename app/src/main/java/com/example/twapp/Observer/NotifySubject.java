package com.example.twapp.Observer;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;


public class NotifySubject implements Subject {


    private String subjectState;

    private List<Observer> observers;


    public NotifySubject() {
        observers = new ArrayList<>();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update); // 尋訪並通知所有 觀察者 進行更新
    }

    public String getState() {
        return subjectState;
    }

    public void setState(String state) {
        this.subjectState = state;
//        notifyObservers(); // 不一定由此做通知
    }

}