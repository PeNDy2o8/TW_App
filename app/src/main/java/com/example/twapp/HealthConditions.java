package com.example.twapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.security.acl.LastOwnerException;
import java.sql.Array;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import kotlin.contracts.Returns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class HealthConditions extends AppCompatActivity {

    private String HR,BO,State,LHR;
    private Handler handler=null;
    private TextView tv_HeartRhythm = null;
    private TextView tv_BloodOxygen = null;
    private TextView tv_State = null;
    private TextView tv_Date = null;
    private TextView tv_LastHeartRhythm = null;
    String tsSt = "";
    DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    private TextView tv_HealthConditonTitle,textView7,textView10,textView11,textView17,textView13,tv_LastTime;
    public static float fontsize = 20;
    public void onResume(){
        super.onResume();
        tv_HealthConditonTitle = findViewById(R.id.tv_HealthConditonTitle);
        tv_HeartRhythm = findViewById(R.id.tv_HeartRhythm);
        textView7 = findViewById(R.id.textView7);
        tv_BloodOxygen = findViewById(R.id.tv_BloodOxygen);
        textView10 = findViewById(R.id.textView10);
        textView11 = findViewById(R.id.textView11);
        tv_LastTime = findViewById(R.id.tv_LastTime);
        tv_State = findViewById(R.id.tv_State);
        tv_Date = findViewById(R.id.tv_Date);
        tv_LastHeartRhythm = findViewById(R.id.tv_LastHeartRhythm);
        textView17 = findViewById(R.id.textView17);
        textView13 = findViewById(R.id.textView13);

        tv_HealthConditonTitle.setTextSize(fontsize);
        tv_HeartRhythm.setTextSize(fontsize);
        textView7.setTextSize(fontsize);
        tv_BloodOxygen.setTextSize(fontsize);
        textView10.setTextSize(fontsize);
        textView11.setTextSize(fontsize);
        tv_LastTime.setTextSize(fontsize);
        tv_State.setTextSize(fontsize);
        tv_Date.setTextSize(fontsize);
        tv_LastHeartRhythm.setTextSize(fontsize);
        textView17.setTextSize(fontsize);
        textView13.setTextSize(fontsize);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_conditions);
        tv_HeartRhythm = findViewById(R.id.tv_HeartRhythm);
        tv_BloodOxygen = findViewById(R.id.tv_BloodOxygen);
        tv_State = findViewById(R.id.tv_State);
        tv_Date = findViewById(R.id.tv_Date);
        tv_LastHeartRhythm = findViewById(R.id.tv_LastHeartRhythm);
        handler = new Handler();
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    class HRget extends AsyncTask<Void, Void, Void> {
                        OkHttpClient client = new OkHttpClient();
                        @Override
                        protected Void doInBackground(Void... voids) {
                            Request request = new Request.Builder()
                                    .url("https://g8.minouo.eu.org:443/Condition/gettop2/4")
                                    .build();
                            try (Response response = client.newCall(request).execute()) {
                                if (response.code() == 200) {
                                    String result = response.body().string();
                                    JSONArray j = new JSONArray(result);
                                    Timestamp t = new Timestamp(j.getJSONObject(1).getLong("time_stamp"));
                                    tsSt = sdf.format(t);

                                    HR = j.getJSONObject(0).getString("heartrhythm");
                                    BO = j.getJSONObject(0).getString("bloodyoxy");
                                    State = j.getJSONObject(1).getString("elder_state");
                                    LHR = j.getJSONObject(1).getString("heartrhythm");

                                }

                            } catch (IOException | JSONException e) {
                                e.printStackTrace();
                            }
                            return null;
                        }
                        protected void onPostExecute(Void t) {
                                tv_HeartRhythm.setText(HR);
                                tv_BloodOxygen.setText(BO);
                                tv_State.setText(State);
                                tv_Date.setText(tsSt);
                                tv_LastHeartRhythm.setText(LHR);
                        }
                    }
                    new HRget().execute();

                    try { Thread.sleep(10000);

                    } catch (InterruptedException e) {

                        e.printStackTrace();

                    }
                }
            }
        }).start();
    }
}
