package com.example.twapp.Observer;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.twapp.Notify;
import com.example.twapp.R;
import com.example.twapp.testReceiver;

import java.nio.channels.Channel;

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
        Intent intent = new Intent(context,testReceiver.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,1,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        Notification.Builder builder = new Notification.Builder(context);
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("訊息")
                .setContentText("跌倒啦~")
                .setChannelId("ID")
                .addAction(R.drawable.ic_launcher_background,"顯示訊息",pendingIntent);

        Notification notification=builder.build();
        notificationManager.notify(1,notification);
    }
}