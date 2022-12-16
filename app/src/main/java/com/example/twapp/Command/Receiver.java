package com.example.twapp.Command;

import android.content.Context;
import android.content.Intent;

public class Receiver {
    protected Context context;
    public Receiver(Context context){
        this.context = context;
    }
    public void action(Class<?> tClass){
        Intent intent = new Intent(context, tClass);
        context.startActivity(intent);
    }
}
