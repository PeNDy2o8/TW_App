package com.example.twapp;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.TextView;

public class Warning_Algo implements Algorithms {
    @Override
    public void setAlarm(TextView hr) {
        hr.setTextColor(Color.rgb(200, 0, 0));
        hr.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
    }
}
