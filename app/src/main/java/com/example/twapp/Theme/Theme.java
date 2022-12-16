package com.example.twapp.Theme;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.twapp.R;

public class Theme extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**從SharedPreferences中垃取目前背景色彩的設定
         * (備註：若沒有設定前，預設皆為日間模式，詳見
         * this.isNightModeEnabled = mPrefs.getBoolean(NIGHT_MODE, false);
         * 這一行)*/
        System.out.println("oncreate");
        setContentView(R.layout.activity_theme);



        if (Theme_state.getInstance().isNightMode()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        setContentView(R.layout.activity_theme);

        @SuppressLint("UseSwitchCompatOrMaterialCode")
        Switch sw = findViewById(R.id.btn_style);
        /**偵測目前的模式，如果是夜間模式的話switch設定為打開*/
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            sw.setChecked(true);
        }

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    /**設定為夜間模式，並將設定寫入SharedPreferences*/
                    Theme_state.getInstance().setIsNightModeEnabled(true);
                } else {
                    /**設定為日間模式，並將設定寫入SharedPreferences*/
                    Theme_state.getInstance().setIsNightModeEnabled(false);
                }
                /**將此頁面finish掉後重新打開*/
                Intent intent = getIntent();
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                startActivity(intent);
            }
        });


    }

    }






    /*public static final String TAG = FCMService.TAG;
    private Button btn_Theme_one;
    private Button btn_Theme_two;
    private Button btn_Theme_three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        FirebaseMessaging.getInstance().subscribeToTopic("news");
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (!task.isSuccessful()) return;
                String token = task.getResult();
                Log.d(TAG, "onComplete: " + token);
            }
        });
        btn_Theme_one = findViewById(R.id.btn_Theme_one);
        btn_Theme_two = findViewById(R.id.btn_Theme_two);
        btn_Theme_three = findViewById(R.id.btn_Theme_three);
        btn_Theme_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_Theme_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_Theme_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }*/



