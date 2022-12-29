package com.example.twapp.Template;

import android.content.Context;
import android.net.Uri;

public class Mute extends Ringtone {

    public Mute(Context context) {
        super(context);
    }

    @Override
    public Uri setChose() {
        return null;
    }
    public boolean CheckSoundNotMute() {
        return false;
    }
}
