package com.example.twapp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Attention_Algo implements Algorithms {

    @Override
    public void setAlarm(TextView hr) {
        hr.setTextColor(Color.rgb(210, 200, 0));
        hr.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
    }
}
