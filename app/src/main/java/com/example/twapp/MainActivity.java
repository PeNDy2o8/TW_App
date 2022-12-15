package com.example.twapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.util.Log;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
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
    private Button btn_Light;
    private Button btn_setting;
    private Button btn_RingChange;
    private Button btn_changeicon;
    private Button btn_Theme;
    private  Button btn_LogIn;
//    private Button btn_change;
    private Button btn_Notify;
    DrawerLayout drawerLayout;
    public static float fontsize = 20;
    public void onResume(){
        super.onResume();
        btn_setting = findViewById(R.id.btn_setting);
        btn_HealthConditions = findViewById(R.id.btn_HealthConditions);
        btn_AbnormalRecord = findViewById(R.id.btn_AbnormalRecord);
        btn_HistoryHealthConditions = findViewById(R.id. btn_HistoryHealthConditions);
        btn_HistoryLocation = findViewById(R.id.btn_HistoryLocation);
        btn_Light = findViewById(R.id. btn_Light);
        btn_CurrentLocation = findViewById(R.id.btn_CurrentLocation);
        btn_RingChange = findViewById(R.id.btn_RingChange);
        btn_Notify = findViewById(R.id.btn_Notify);



        btn_setting.setTextSize(fontsize);
        btn_HealthConditions.setTextSize(fontsize);
        btn_AbnormalRecord.setTextSize(fontsize);
        btn_HistoryHealthConditions.setTextSize(fontsize);
        btn_HistoryLocation.setTextSize(fontsize);
        btn_Light.setTextSize(fontsize);
        btn_CurrentLocation.setTextSize(fontsize);
        btn_RingChange.setTextSize(fontsize);
        btn_Notify.setTextSize(fontsize);


    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawers();
            }else finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

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
        drawerLayout=findViewById(R.id.drawer_layout);

        btn_CurrentLocation = findViewById(R.id.btn_CurrentLocation);
        btn_HistoryLocation = findViewById(R.id.btn_HistoryLocation);
        btn_HealthConditions = findViewById(R.id.btn_HealthConditions);
        btn_HistoryHealthConditions = findViewById(R.id.btn_HistoryHealthConditions);
        btn_AbnormalRecord = findViewById(R.id.btn_AbnormalRecord);
        btn_Light = findViewById(R.id.btn_Light);
        btn_RingChange = findViewById(R.id.btn_RingChange);
        btn_changeicon = findViewById(R.id.btn_changeicon);
//        btn_change = findViewById(R.id.btn_change);
        btn_Notify = findViewById(R.id.btn_Notify);
        btn_setting = findViewById(R.id.btn_setting);
        btn_Theme = findViewById(R.id.btn_Theme);

        //側拉相關按鈕
        btn_LogIn=findViewById(R.id.btn_login);
        btn_LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,Logins.class);
                startActivity(intent);

            }
        });
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

        btn_RingChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RingChange.class);
                startActivity(intent);
            }
        });
        btn_changeicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChooseiconActivity.class);
                startActivity(intent);
            }
        }
        );
        btn_Notify.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Notify.class);
                startActivity(intent);
            }
        });

    }
}