package com.example.twapp.Strategy;

import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

public interface Algorithms {
    abstract public void setAlarm(TextView hr, AlertDialog.Builder dialog);
}
