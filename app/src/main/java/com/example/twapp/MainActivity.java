package com.example.twapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.util.Log;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.twapp.Command.AbnormalRecord_command;
import com.example.twapp.Command.Changeicon_command;
import com.example.twapp.Command.Command;
import com.example.twapp.Command.CurrentLocation_command;
import com.example.twapp.Command.HealthConditions_command;
import com.example.twapp.Command.HistoryHealthConditions_command;
import com.example.twapp.Command.HistoryLocation_command;
import com.example.twapp.Command.Login_command;
import com.example.twapp.Command.Receiver;
import com.example.twapp.Command.RingChange_command;
import com.example.twapp.Command.Setting_command;
import com.example.twapp.ChangeIcon.Myappicon;
import com.example.twapp.Login.Logins;
import com.example.twapp.Login.UserInfo;
import com.example.twapp.Observer.Observer;
import com.example.twapp.Visitor.LoggedInVisitor;
import com.example.twapp.Visitor.NotLoggedInVisitor;
import com.example.twapp.Visitor.Visitor;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;




public class MainActivity extends AppCompatActivity implements Observer {
    static String name;
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
    private Visitor visitor = new LoggedInVisitor();
    private Button btn_logout;
    DrawerLayout drawerLayout;
    TextView username;
    Myappicon gv;
    Toolbar toolbar;

    public static float fontsize = 20;
    public void onResume(){
        super.onResume();
        btn_setting = findViewById(R.id.btn_setting);
        btn_HealthConditions = findViewById(R.id.btn_HealthConditions);
        btn_AbnormalRecord = findViewById(R.id.btn_AbnormalRecord);
        btn_HistoryHealthConditions = findViewById(R.id. btn_HistoryHealthConditions);
        btn_HistoryLocation = findViewById(R.id.btn_HistoryLocation);
        btn_CurrentLocation = findViewById(R.id.btn_CurrentLocation);
        btn_RingChange = findViewById(R.id.btn_RingChange);
        btn_logout = findViewById(R.id.btn_logout);


        btn_setting.setTextSize(fontsize);
        btn_HealthConditions.setTextSize(fontsize);
        btn_AbnormalRecord.setTextSize(fontsize);
        btn_HistoryHealthConditions.setTextSize(fontsize);
        btn_HistoryLocation.setTextSize(fontsize);
        btn_CurrentLocation.setTextSize(fontsize);
        btn_RingChange.setTextSize(fontsize);


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
        Receiver receiver = new Receiver(this);
        gv=(Myappicon)getApplicationContext();
        if (gv.getName()==null){
            visitor = new NotLoggedInVisitor(receiver);
        }else{
            visitor = new LoggedInVisitor();
        }

        Command abnormalRecord_command          = new AbnormalRecord_command(receiver);
        Command changeicon_command              = new Changeicon_command(receiver);
        Command currentLocation_command         = new CurrentLocation_command(receiver);
        Command healthConditions_command        = new HealthConditions_command(receiver);
        Command historyHealthConditions_command = new HistoryHealthConditions_command(receiver);
        Command historyLocation_command         = new HistoryLocation_command(receiver);
        Command login_command                   = new Login_command(receiver);
        Command ringChange_command              = new RingChange_command(receiver);
        Command setting_command                 = new Setting_command(receiver);




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
        btn_RingChange = findViewById(R.id.btn_RingChange);
        btn_changeicon = findViewById(R.id.btn_changeicon);
        btn_setting = findViewById(R.id.btn_setting);

        username=findViewById(R.id.user_name);



        //側拉相關按鈕
        btn_LogIn=findViewById(R.id.btn_login);
        btn_logout = findViewById(R.id.btn_logout);
        btn_LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login_command.accept(visitor);
            }
        });
        btn_logout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gv.setName(null);
                gv.setAccount(null);
                gv.setTelephone(null);
                System.out.println(UserInfo.getName());
//                Intent intent=new Intent(MainActivity.this, MainActivity.class);
//                startActivity(intent);
                MainActivity.this.finish();

            }
        });

        btn_CurrentLocation.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                currentLocation_command.accept(visitor);
            }
        });


        btn_HistoryLocation.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                historyLocation_command.accept(visitor);
            }
        });

        btn_HealthConditions.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                healthConditions_command.accept(visitor);
            }
        });

        btn_HistoryHealthConditions.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                historyHealthConditions_command.accept(visitor);
            }
        });

        btn_AbnormalRecord.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                abnormalRecord_command.accept(visitor);
            }
        });

        btn_RingChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ringChange_command.accept(visitor);
            }
        });
        btn_changeicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeicon_command.accept(visitor);
            }
        }
        );

        btn_setting.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                setting_command.accept(visitor);
            }
        });
        gv.attach(this);
        username=findViewById(R.id.user_name);
        username.setText(name);
    }

    @Override
    public void update() {
        name=gv.getName();
        username=findViewById(R.id.user_name);
        username.setText(name);
        username.setTextSize(12);
        username.setText(gv.getName());
        Toast.makeText(MainActivity.this,"welcome! "+username.getText(),Toast.LENGTH_LONG).show();
    }
}