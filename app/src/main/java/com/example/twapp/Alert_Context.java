package com.example.twapp;

import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

public class Alert_Context {
    Algorithms algorithms;

    public void setAlgorithm(String HR) {
        int hr = Integer.parseInt(HR);
        if ((hr > 100 && hr < 130) || (hr < 60 && hr > 30)) {
            this.algorithms = new Attention_Algo();
        } else if (hr > 130 || hr < 30) {
            this.algorithms = new Warning_Algo();
        }
    }

    public void setAlarm(TextView hr, AlertDialog.Builder dialog) {
        this.algorithms.setAlarm(hr, dialog);
    }
}
