package com.example.twapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;

import java.util.List;

public class Change extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        findViewById(R.id.btn1).setOnClickListener(v -> {
//            changeIcon(this, "com.example.twapp.A1", "cn.fengrong.appiconchanger.StartUpAliasActivity1")

            changeIcon("com.example.twapp.A1");
        });
        findViewById(R.id.btn2).setOnClickListener(v -> {
            changeIcon("com.example.twapp.A2");
        });
        findViewById(R.id.btn3).setOnClickListener(v -> {
            changeIcon("com.example.twapp.A3");
        });
        findViewById(R.id.btn4).setOnClickListener(v -> {
            changeIcon("com.example.twapp.MainActivity");
        });
    }

    private void changeIcon(String name){
        PackageManager pm = getPackageManager();
        pm.setComponentEnabledSetting(getComponentName(),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        pm.setComponentEnabledSetting(new ComponentName(this, name),
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);

        restart(pm);
    }

    public void restart(PackageManager pm){
        ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        List<ResolveInfo> resolveInfos = pm.queryIntentActivities(intent, 0);
        for (ResolveInfo resolveInfo : resolveInfos) {
            if (resolveInfo.activityInfo != null) {
                am.killBackgroundProcesses(resolveInfo.activityInfo.packageName);
            }
        }

    }
}