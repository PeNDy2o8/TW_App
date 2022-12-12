package com.example.twapp;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

public class ChooseiconActivity extends AppCompatActivity implements Foregroundback.Listener {

    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooseicon);

        //添加APP前後台監聽
        Foregroundback.get(this).addListener(this);

        findViewById(R.id.icon4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 0;

            }
        });

        findViewById(R.id.icon1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 1;

            }
        });
        findViewById(R.id.icon2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 2;

            }
        });

        findViewById(R.id.icon3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 3;
            }
        });
    }

    @Override
    protected void onDestroy() {
        // 移除app前後台監聽
        Foregroundback.get(this).removeListener(this);
        super.onDestroy();
    }

    @Override
    public void onForeground() {
    }

    @Override
    public void onBackground() {
        //根據需求設置切換條件

//        switch (position){
//            case 0:
//                setDefaultAlias();
//                break;
//            case 1:
//                setAlias1();
//                break;
//            case 2:
//                setAlias2();
//                break;
//            case 3:
//                setAlias3();
//                break;
//        }

        if (position == 0) {
            setDefaultAlias();
        } else if(position == 1){
            setAlias1();
        }else if(position == 2){
            setAlias2();
        }else if(position == 3){
            setAlias3();
        }

    }

    public ComponentName componentName1() {
        return new ComponentName(this, "com.example.twapp.Defaulticon");
    }
    public ComponentName componentName2() {
        return new ComponentName(this, "com.example.twapp.W1");
    }
    public ComponentName componentName3() {
        return new ComponentName(this, "com.example.twapp.W2");
    }
    public ComponentName componentName4() {
        return new ComponentName(this, "com.example.twapp.W3");
    }

    /**
     * 啟動入口
     */
    public void setDefaultAlias() {
        PackageManager packageManager = getPackageManager();

        ComponentName name1 = componentName1();
        packageManager.setComponentEnabledSetting(name1, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);

        ComponentName name2 = componentName2();
        packageManager.setComponentEnabledSetting(name2, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);

        ComponentName name3 = componentName3();
        packageManager.setComponentEnabledSetting(name3, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);

        ComponentName name4 = componentName4();
        packageManager.setComponentEnabledSetting(name4, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
    }


    /**
     * setAlias1啟動入口
     */


    public void setAlias1() {

        PackageManager packageManager = getPackageManager();

        ComponentName name1 = componentName1();
        packageManager.setComponentEnabledSetting(name1, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);

        ComponentName name2 = componentName2();
        packageManager.setComponentEnabledSetting(name2, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);

        ComponentName name3 = componentName3();
        packageManager.setComponentEnabledSetting(name3, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);

        ComponentName name4 = componentName4();
        packageManager.setComponentEnabledSetting(name4, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
    }

    public void setAlias2(){
        PackageManager packageManager = getPackageManager();

        ComponentName name1 = componentName1();
        packageManager.setComponentEnabledSetting(name1, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);

        ComponentName name2 = componentName2();
        packageManager.setComponentEnabledSetting(name2, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);

        ComponentName name3 = componentName3();
        packageManager.setComponentEnabledSetting(name3, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);

        ComponentName name4 = componentName4();
        packageManager.setComponentEnabledSetting(name4, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
    }

    public void setAlias3(){
        PackageManager packageManager = getPackageManager();

        ComponentName name1 = componentName1();
        packageManager.setComponentEnabledSetting(name1, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);

        ComponentName name2 = componentName2();
        packageManager.setComponentEnabledSetting(name2, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);

        ComponentName name3 = componentName3();
        packageManager.setComponentEnabledSetting(name3, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);

        ComponentName name4 = componentName4();
        packageManager.setComponentEnabledSetting(name4, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);

    }
}