package com.example.twapp;

import android.app.Application;

public class Myappicon extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Foregroundback.init(this);
    }
}
