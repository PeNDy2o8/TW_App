package com.example.twapp.Template;
import static com.google.firebase.FirebaseApp.getInstance;

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
    public void test(Uri uri){
    android.media.Ringtone r = RingtoneManager.getRingtone(c,uri);
    r.play();
    }
    public boolean CheckSoundNotMute() {
        return true;
    }
    public final void execute(){
        setDefault(setChose());
        if(CheckSoundNotMute()){
            test(setChose());
        }
    }
}
