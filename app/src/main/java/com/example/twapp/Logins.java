package com.example.twapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Logins extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("oncreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logins);
    }
}