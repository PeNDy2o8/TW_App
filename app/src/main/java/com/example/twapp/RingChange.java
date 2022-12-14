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
                Ringtone ringtone1=new rington1();
                Ringtone ringtone2=new rington2();
                Ringtone ringtone3=new rington3();
                switch (checkedId) {
                    case R.id.radioButton1:
                        if (r.isChecked())
                        ringtone1.play();
                        break;
                    case R.id.radioButton2:
                        if (r.isChecked())
                        ringtone2.play();
                        break;
                    case R.id.radioButton3:
                        if (r.isChecked())
                        ringtone3.play();
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
        abstract void setChose();
        public final void play(){
            getDefault();
            setChose();
        }
    }
    public class rington1 extends Ringtone{
        @Override
        void setChose() {
            Uri newUri =Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ring_nokia_x_tune);
            RingtoneManager.setActualDefaultRingtoneUri(
                    getApplicationContext(),
                    RingtoneManager.TYPE_NOTIFICATION,
                    newUri);
        }
    }
    public class rington2 extends Ringtone{
        @Override
        void setChose() {
            Uri newUri =Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.notification);
            RingtoneManager.setActualDefaultRingtoneUri(
                    getApplicationContext(),
                    RingtoneManager.TYPE_NOTIFICATION,
                    newUri);
        }
    }
    public class rington3 extends Ringtone{
        @Override
        void setChose() {
            Uri newUri =Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ring_google_event);
            RingtoneManager.setActualDefaultRingtoneUri(
                    getApplicationContext(),
                    RingtoneManager.TYPE_NOTIFICATION,
                    newUri);
        }
    }
}

