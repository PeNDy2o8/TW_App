package com.example.twapp;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FontSize  extends AppCompatActivity{

    TextView tD;
    EditText eD;
    SeekBar sB;
    int seekValue;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fontsize);
        eD = findViewById(R.id.editTextTextPersonName);
        tD = findViewById(R.id.textView);
        sB = findViewById(R.id.seekBar);
        sB.setMax(6);

        sB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekValue = (progress+3) * 3;
                MainActivity.fontsize = seekValue;
                ElectroCardioGraphy.fontsize = seekValue;
                AbnormalRecord.fontsize = seekValue;
                HistoryLocation.fontsize =seekValue;
                HistoryHealthConditions.fontsize = seekValue;
                HealthConditions.fontsize = seekValue;

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                String temp =  "Processing...";
                tD.setText(temp);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tD.setText(eD.getText().toString());
                tD.setTextSize(seekValue);
            }
        });

    }

}
