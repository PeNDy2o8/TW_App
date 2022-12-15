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


    public class AbnormalRecord extends AppCompatActivity {
    ListView list_Abnormal;
    OkHttpClient client = OkHttpsSingle.getOkHttp();
    List<String> values = new ArrayList<>();

    String tsStr = "";
    DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private TextView tv_AbnormalRecordTitle;
    public static float fontsize = 20;
    public void onResume(){
        super.onResume();
        tv_AbnormalRecordTitle = findViewById(R.id.tv_AbnormalRecordTitle);

        tv_AbnormalRecordTitle.setTextSize(fontsize);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abnormal_record);
        list_Abnormal = (ListView) findViewById(R.id.list_Abnormal);
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, values);
        list_Abnormal.setAdapter(adapter);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));

        class getAbnormalRecordTask extends AsyncTask<Void, Void, Void> {
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
                            if (j.getString("elder_state").equals("abnormal")){
                                Timestamp ts = new Timestamp(j.getLong("time_stamp"));
                                tsStr = sdf.format(ts);
                                values.add(String.format("Heart Rhythm：%s    Blood Oxygen：%s  \n%s",
                                        j.getString("heartrhythm"),
                                        j.getString("bloodyoxy"),
                                        tsStr
                                ));
                            }
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
        new getAbnormalRecordTask().execute();

    }
}