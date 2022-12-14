package com.example.twapp;

import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RingChange extends AppCompatActivity {
    Button btnSelRingtone;
    TextView textView;
    RadioGroup radioGroup;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ring_change);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioButton r = ( RadioButton)findViewById(checkedId);
                Ringtone nokia=new Nokia();
                Ringtone duck=new Duck();
                Ringtone google=new Google();
                switch (checkedId) {
                    case R.id.radioButton1:
                        if (r.isChecked())
                        nokia.play();
                        break;
                    case R.id.radioButton2:
                        if (r.isChecked())
                        duck.play();
                        break;
                    case R.id.radioButton3:
                        if (r.isChecked())
                        google.play();
                        break;
                }
            }
        });

    }
    public RadioGroup setGlobalVariable(){
        RadioGroup rg = ( RadioGroup) findViewById(R.id.radioGroup);
        return rg;
    }

    public abstract class Ringtone{
        void getDefault(){
            final Uri currentTone=
                    RingtoneManager.getActualDefaultRingtoneUri(RingChange.this,
                            RingtoneManager.TYPE_NOTIFICATION);
        }
        abstract Uri setChose();
        void setDefault(Uri uri){
            RingtoneManager.setActualDefaultRingtoneUri(
                    getApplicationContext(),
                    RingtoneManager.TYPE_NOTIFICATION,
                    uri);
        }
        public final void play(){
            getDefault();
            setDefault(setChose());
        }
    }
    public class Nokia extends Ringtone{
        @Override
        Uri setChose() {
            Uri newUri =Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ring_nokia_x_tune);
            return newUri;
        }
    }
    public class Duck extends Ringtone{
        @Override
        Uri setChose() {
            Uri newUri =Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.notification);
            return newUri;
        }
    }
    public class Google extends Ringtone{
        @Override
        Uri setChose() {
            Uri newUri =Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ring_google_event);
            return newUri;
        }
    }
}

