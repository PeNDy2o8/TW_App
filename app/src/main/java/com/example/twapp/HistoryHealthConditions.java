package com.example.twapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.Array;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class HistoryHealthConditions extends AppCompatActivity {
    ListView list_HistoryHealthConditions;
    OkHttpClient client = OkHttpsSingle.getOkHttp();
    List<String> values = new ArrayList<>();
    String tsStr = "";
    DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private TextView tv_HistoriclHealthConditions;
    public static float fontsize = 20;
    public void onResume(){
        super.onResume();
        tv_HistoriclHealthConditions = findViewById(R.id.tv_HistoriclHealthConditions);

        tv_HistoriclHealthConditions.setTextSize(fontsize);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_health_conditions);
        list_HistoryHealthConditions = (ListView) findViewById(R.id.list_HistoryHealthConditions);
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, values);

        list_HistoryHealthConditions.setAdapter(adapter);

        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));

        class getHistoryHealthConditionsTask extends AsyncTask<Void, Void, Void> {
            @Override
            protected Void doInBackground(Void... Void) {
                Request request = new Request.Builder()
                        .url("https://g8.minouo.eu.org/Condition/get/4")
                        .build();

                try (Response response = client.newCall(request).execute()) {
                    if (response.code() == 200) {
                        JSONArray jsonArray = new JSONArray(response.body().string());
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject j =  jsonArray.getJSONObject(i);
                            Timestamp ts = new Timestamp(j.getLong("time_stamp"));
                            tsStr = sdf.format(ts);
                            values.add(String.format("Hearth Rhythm：%s     blood oxygen：%s \nElder State：%s\n%s",
                                    j.getString("heartrhythm"),
                                    j.getString("bloodyoxy"),
                                    j.getString("elder_state"),
                                    tsStr
                            ));

                        }
                    }

                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                ((ArrayAdapter<?>) adapter).notifyDataSetChanged();
            }
        }
        new getHistoryHealthConditionsTask().execute();

    }
}