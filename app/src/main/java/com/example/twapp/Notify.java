package com.example.twapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.twapp.Observer.NotifyObserver;
import com.example.twapp.Observer.NotifySubject;


public class Notify extends AppCompatActivity
{
    NotificationManager notificationManager;
    NotificationChannel channel;
    Button button;
    Context context = this;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_notify);
        notificationManager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
        channel=new NotificationChannel("ID","com.example.twapp",NotificationManager.IMPORTANCE_HIGH);
        notificationManager.createNotificationChannel(channel);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotifySubject notifySubject = new NotifySubject();
                NotifyObserver observerA = new NotifyObserver(notifySubject); // 實例 具體觀察者 A
                observerA.setcontext(context);
                observerA.setChannel(channel);
                observerA.setNotificationManager(notificationManager);
                notifySubject.attach(observerA); // 觀察者A 訂閱 主題
                notifySubject.setState("消息 1: 跌倒了"); // 變更主題狀態
                notifySubject.notifyObservers();
            }
        });


    }
}