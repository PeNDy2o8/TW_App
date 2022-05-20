package com.example.twapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_WristbandLock;
    private Button btn_CurrentLocation;
    private Button btn_HistoryLocation;
    private Button btn_HealthConditions;
    private Button btn_HistoryHealthConditions;
    private Button btn_AbnormalRecord;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_WristbandLock = findViewById(R.id.btn_WristbandLock);
        btn_CurrentLocation = findViewById(R.id.btn_CurrentLocation);
        btn_HistoryLocation = findViewById(R.id.btn_HistoryLocation);
        btn_HealthConditions = findViewById(R.id.btn_HealthConditions);
        btn_HistoryHealthConditions = findViewById(R.id.btn_HistoryHealthConditions);
        btn_AbnormalRecord = findViewById(R.id.btn_AbnormalRecord);


        btn_WristbandLock.setOnClickListener(new View.OnClickListener(){
            int flag = 0;
            public void onClick(View v){
                switch(flag){
                    case 0:
                        btn_WristbandLock.setActivated(false);
                        flag = 1;
                        break;
                    case 1:
                        btn_WristbandLock.setActivated(true);
                        flag = 0 ;
                        break;
                }
            }
        });

        btn_CurrentLocation.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CurrentLocation.class);
                startActivity(intent);
            }
        });

        btn_HistoryLocation.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,HistoryLocation.class);
                startActivity(intent);
            }
        });

        btn_HealthConditions.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,HealthConditions.class);
                startActivity(intent);
            }
        });

        btn_HistoryHealthConditions.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,HistoryHealthConditions.class);
                startActivity(intent);
            }
        });

        btn_AbnormalRecord.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AbnormalRecord.class);
                startActivity(intent);
            }
        });



    }


}