package com.example.twapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;



public class MainActivity extends AppCompatActivity {
    public static final String TAG = FCMService.TAG;
    private Button btn_CurrentLocation;
    private Button btn_HistoryLocation;
    private Button btn_HealthConditions;
    private Button btn_HistoryHealthConditions;
    private Button btn_AbnormalRecord;
    private Button btn_showimage;
    private Button btn_Light;
    private Button btn_Theme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseMessaging.getInstance().subscribeToTopic("news");
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (!task.isSuccessful())return;
                String token = task.getResult();
                Log.d(TAG, "onComplete: "+token);
            }
        });

        btn_CurrentLocation = findViewById(R.id.btn_CurrentLocation);
        btn_HistoryLocation = findViewById(R.id.btn_HistoryLocation);
        btn_HealthConditions = findViewById(R.id.btn_HealthConditions);
        btn_HistoryHealthConditions = findViewById(R.id.btn_HistoryHealthConditions);
        btn_AbnormalRecord = findViewById(R.id.btn_AbnormalRecord);
        btn_showimage = findViewById(R.id.btn_showimage);
        btn_Light = findViewById(R.id.btn_Light);
        btn_Theme = findViewById(R.id.btn_Theme);



        btn_Light.setOnClickListener(new View.OnClickListener(){
            int flag = 0;
            boolean light ;
            public void onClick(View view){
                switch(flag){
                    case 0:
                        light= true;
                        break;
                    case 1:
                        light= false;
                        break;
                }
            }});

        btn_CurrentLocation.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });
        btn_Theme.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Theme.class);
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

        btn_showimage.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ElectroCardioGraphy.class);
                startActivity(intent);
            }
        });

    }
}