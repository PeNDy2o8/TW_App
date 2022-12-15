package com.example.twapp;

import android.content.Context;
import android.net.Uri;

public class Google extends Ringtone {

    public Google(Context context) {
        super(context);
    }

    @Override
    public Uri setChose() {
        return Uri.parse("android.resource://" + c.getPackageName() + "/" + R.raw.ring_google_event);
    }
}