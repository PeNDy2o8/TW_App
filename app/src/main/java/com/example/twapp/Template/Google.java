package com.example.twapp.Template;

import android.content.Context;
import android.net.Uri;

import com.example.twapp.R;

public class Google extends Ringtone {

    public Google(Context context) {
        super(context);
    }

    @Override
    public Uri setChose() {
        return Uri.parse("android.resource://" + c.getPackageName() + "/" + R.raw.ring_google_event);
    }
}