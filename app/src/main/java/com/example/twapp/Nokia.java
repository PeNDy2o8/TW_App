package com.example.twapp;

import android.content.Context;
import android.net.Uri;

public class Nokia extends Ringtone {

    public Nokia(Context context) {
        super(context);
    }

    @Override
    public Uri setChose() {
        return Uri.parse("android.resource://" + c.getPackageName() + "/" + R.raw.ring_nokia_x_tune);
    }

}
