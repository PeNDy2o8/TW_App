package com.example.twapp;


import android.content.Context;
import android.net.Uri;

public class Duck extends Ringtone {

    public Duck(Context context) {
        super(context);
    }

    @Override
    public Uri setChose() {
        return Uri.parse("android.resource://" + c.getPackageName() + "/" + R.raw.notification);
    }
}
