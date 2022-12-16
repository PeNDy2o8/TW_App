package com.example.twapp.Theme;



import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class Theme_state extends Application {
    public static final String NIGHT_MODE = "NIGHT_MODE";
    private boolean isNightMode = false;
    private static Theme_state singleton = null;

    /**
     * 設置外部接口
     */
    public static Theme_state getInstance() {

        if (singleton == null) {
            singleton = new Theme_state();
        }
        return singleton;
    }

    /**
     * 初始化
     */
    @Override
    public void onCreate(){
        super.onCreate();
        singleton = this;
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        this.isNightMode = mPrefs.getBoolean(NIGHT_MODE, false);
    }

    /**
     * 將現在的日夜間模式狀態顯示給Main傳出外部
     */
    public boolean isNightMode() {
        return isNightMode;
    }

    /**
     * 設置現在使用者所選擇的日夜間狀態
     */
    public void setIsNightModeEnabled(boolean isNightMode) {
        this.isNightMode = isNightMode;
        /**將現在目前的狀態存進SharedPreferences內*/
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putBoolean(NIGHT_MODE, isNightMode);
        editor.apply();
    }
}
