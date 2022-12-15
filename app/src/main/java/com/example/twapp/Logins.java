package com.example.twapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Logins extends AppCompatActivity {
    private Button btn_create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("oncreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logins);
        btn_create=findViewById(R.id.createAccount);

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Logins.this,CreateAcount.class);
                startActivity(intent);
            }
        });


    }
}