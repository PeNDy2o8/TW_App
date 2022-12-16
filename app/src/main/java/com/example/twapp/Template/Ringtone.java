package com.example.twapp.Template;
import android.content.Context;
import android.media.RingtoneManager;
import android.net.Uri;

public abstract class Ringtone {

    Context c;
    public Ringtone(Context context) {
            c = context;
        }
    abstract Uri setChose();
    public void setDefault(Uri uri){
        RingtoneManager.setActualDefaultRingtoneUri(
                c,
                RingtoneManager.TYPE_NOTIFICATION,
                uri);
    }
    public final void play(){
        setDefault(setChose());
    }
}
