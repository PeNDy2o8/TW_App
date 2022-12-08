package com.example.twapp;

import android.app.Activity;
import android.content.Intent;
public class Utils
{

    private static int sTheme = 3;
    public final static int THEME_one = 0;
    public final static int THEME_two = 1;
    public final static int THEME_three = 2;
    /**
     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
     */
    public static void changeToTheme(Activity activity, int theme)
    {
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity,activity.getClass()));
    }
    /** Set the theme of the activity, according to the configuration. */
    public static void onActivityCreateSetTheme(Activity activity)
    {
        switch (sTheme)
        {
            case THEME_one:
                activity.setTheme(R.style.Theme_one);
                System.out.println("theme one");
                break;
            case THEME_two:
                activity.setTheme(R.style.Theme_two);
                System.out.println("theme two");
                break;
            case THEME_three:
                activity.setTheme(R.style.Theme_three);
                System.out.println("theme three");
                break;
        }
    }
}