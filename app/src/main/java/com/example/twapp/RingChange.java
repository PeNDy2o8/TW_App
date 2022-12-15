package com.example.twapp;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class RingChange extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ring_change);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioButton r = ( RadioButton)findViewById(checkedId);
                Ringtone nokia=new Nokia(getApplicationContext());
                Ringtone duck=new Duck(getApplicationContext());
                Ringtone google=new Google(getApplicationContext());
                switch (checkedId) {
                    case R.id.radioButton1:
                        if (r.isChecked())
                        nokia.play();
                        break;
                    case R.id.radioButton2:
                        if (r.isChecked())
                        duck.play();
                        break;
                    case R.id.radioButton3:
                        if (r.isChecked())
                        google.play();
                        break;
                }
            }
        });

    }
}

