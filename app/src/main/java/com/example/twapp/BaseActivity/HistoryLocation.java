package com.example.twapp.BaseActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.twapp.OkHttpsSingle;
import com.example.twapp.R;

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


public class HistoryLocation extends AppCompatActivity {
    ListView list_HistoryLocation;
    OkHttpClient client = OkHttpsSingle.getOkHttp();
    List<String> values = new ArrayList<>();
    String tsStr = "";
    DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private TextView tv_Historicl_Location;
    public static float fontsize = 20;
    public void onResume(){
        super.onResume();
        tv_Historicl_Location = findViewById(R.id.tv_Historicl_Location);

        tv_Historicl_Location.setTextSize(fontsize);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_location);
        list_HistoryLocation = (ListView) findViewById(R.id.list_HistoryLocation);
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, values);
        list_HistoryLocation.setAdapter(adapter);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));

        class getHistoryLocationTask extends AsyncTask<Void, Void, Void> {
            @Override
            protected Void doInBackground(Void... Void) {
                Request request = new Request.Builder()
                        .url("http://5350-49-213-197-9.ngrok.io/Condition/get/2")
                        .build();

                try (Response response = client.newCall(request).execute()) {
                    if (response.code() == 200) {
                        JSONArray jsonArray = new JSONArray(response.body().string());
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject j =  jsonArray.getJSONObject(i);
                            Timestamp ts = new Timestamp(j.getLong("time_stamp"));
                            tsStr = sdf.format(ts);
                            values.add(String.format("longitude:%s    latitude:%s\n%s",
                                    j.getString("longgps"),
                                    j.getString("latigps"),
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
        new getHistoryLocationTask().execute();

    }
}