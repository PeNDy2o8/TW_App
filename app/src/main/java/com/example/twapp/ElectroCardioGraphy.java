package com.example.twapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ElectroCardioGraphy extends AppCompatActivity {
    private TextView textView25,textView24,textView21,textView22,textView16,textView14,textView15,textView5,textView6,textView18,textView19,textView20,textView23;
    public static float fontsize = 20;
    public void onResume(){
        super.onResume();
        textView25 = findViewById(R.id.textView25);
        textView24 = findViewById(R.id.textView24);
        textView21 = findViewById(R.id.textView21);
        textView22 = findViewById(R.id.textView22);
        textView16 = findViewById(R.id.textView16);
        textView14 = findViewById(R.id.textView14);
        textView15 = findViewById(R.id.textView15);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView18 = findViewById(R.id.textView18);
        textView19 = findViewById(R.id.textView19);
        textView20 = findViewById(R.id.textView20);
        textView23 = findViewById(R.id.textView23);

        textView25.setTextSize(fontsize);
        textView24.setTextSize(fontsize);
        textView21.setTextSize(fontsize);
        textView22.setTextSize(fontsize);
        textView16.setTextSize(fontsize);
        textView14.setTextSize(fontsize);
        textView15.setTextSize(fontsize);
        textView5.setTextSize(fontsize);
        textView6.setTextSize(fontsize);
        textView18.setTextSize(fontsize);
        textView19.setTextSize(fontsize);
        textView20.setTextSize(fontsize);
        textView23.setTextSize(fontsize);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electro_cardio_graphy);
    }
}