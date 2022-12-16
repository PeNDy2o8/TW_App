package com.example.twapp;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

public class Warning_Algo implements Algorithms {

    static boolean d = true;
    Button negative ,neutral , possitive;
    public void setAlarm(TextView hr, AlertDialog.Builder dialog) {
        hr.setBackgroundColor(Color.rgb(200, 0, 0));
        hr.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        if(d) {

            dialog.setTitle("                 Danger!");
            dialog.setIcon(android.R.drawable.ic_dialog_alert);
            dialog.setMessage("Your heart rate is in the Danger Zone!\nHelps needed!");
            dialog.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });



            AlertDialog ad = dialog.create();
            ad.show();
            negative = ad.getButton(AlertDialog.BUTTON_NEGATIVE);
            negative.setBackgroundColor(Color.rgb(0,0,0));

        }
    }
}

