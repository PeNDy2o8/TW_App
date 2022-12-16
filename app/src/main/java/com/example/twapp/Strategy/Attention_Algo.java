package com.example.twapp.Strategy;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;

import android.widget.TextView;

public class Attention_Algo implements Algorithms {
    static boolean d = true;
    Button negative ,neutral , possitive;
    public void setAlarm(TextView hr, AlertDialog.Builder dialog) {
        hr.setBackgroundColor(Color.rgb(210, 200, 0));
        hr.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        if(d) {

            dialog.setTitle("                 Notice!");
            dialog.setIcon(android.R.drawable.ic_dialog_info);
            dialog.setMessage("Seems that your heart rate is unusual\nAre you exercising?");
            dialog.setPositiveButton("No", null);
            dialog.setNeutralButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    d = false;
                }
            });
            //dialog.setNegativeButton("No" , null);
            AlertDialog ad = dialog.create();
            ad.show();
            neutral = ad.getButton(AlertDialog.BUTTON_NEUTRAL);
            neutral.setBackgroundColor(Color.rgb(0,0,0));
            possitive = ad.getButton(AlertDialog.BUTTON_POSITIVE);
            possitive.setBackgroundColor(Color.rgb(0,0,0));

        }
    }
}
