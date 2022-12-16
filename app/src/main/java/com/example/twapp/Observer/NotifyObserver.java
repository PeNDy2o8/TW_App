package com.example.twapp.Observer;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.twapp.R;

public class NotifyObserver implements Observer {
    NotificationManager notificationManager;
    NotificationChannel channel;
    Context context;
    Notification.Builder builder;

    private NotifySubject notifySubject; // 持有指向 ConcreteSubject 物件的 reference


    public NotifyObserver(NotifySubject concreteSubject) {
        this.notifySubject = concreteSubject;
    }

    public void setcontext(Context context){
        this.context = context;
    }

    public void setNotificationManager(NotificationManager notificationManager){
        this.notificationManager = notificationManager;
    }
    public void setChannel(NotificationChannel channel){
        this.channel = channel;
    }
    public void  setBuilder(Notification.Builder builder){
        this.builder = builder;

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void update() {


        Notification.Builder builder = new Notification.Builder(context);
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("訊息")
                .setContentText("跌倒啦~")
                .setChannelId("ID");


        Notification notification=builder.build();
        notificationManager.notify(1,notification);
    }
}