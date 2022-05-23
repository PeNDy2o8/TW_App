package com.example.twapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class HistoryHealthConditions extends AppCompatActivity {
    ListView list_HistoryHealthConditions;
    String[] values = new String[]{
            "A","B","C"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_health_conditions);
        list_HistoryHealthConditions =(ListView) findViewById(R.id.list_HistoryHealthConditions);
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,values);
        list_HistoryHealthConditions.setAdapter(adapter);
    }
}