package com.example.twapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.sql.Array;

public class HistoryLocation extends AppCompatActivity {
    ListView list_HistoryLocation;
    String[] values = new String[]{
            "A","B","C"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_location);
        list_HistoryLocation = (ListView)findViewById(R.id.list_HistoryLocation);
        ListAdapter adapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1 ,values);
        list_HistoryLocation.setAdapter(adapter);
    }
}