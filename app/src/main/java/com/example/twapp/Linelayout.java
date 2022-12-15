//package com.example.twapp;
//
//import android.os.Bundle;
//import android.view.KeyEvent;
//import android.widget.Button;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.view.GravityCompat;
//import androidx.drawerlayout.widget.DrawerLayout;
//
//public class Linelayout extends AppCompatActivity {
//    DrawerLayout drawerLayout;
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
//            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
//                drawerLayout.closeDrawers();
//            }else finish();
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Button bt01 = findViewById(R.id.button3);
//
//        bt01.setOnClickListener((v -> {
//            Toast.makeText(this,"點擊了第一個Button",Toast.LENGTH_SHORT).show();
//        }));
//
//    }
//}
