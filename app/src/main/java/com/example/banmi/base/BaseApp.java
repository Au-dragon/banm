package com.example.banmi.base;

import android.app.Application;
import android.hardware.display.DisplayManager;
import android.support.v7.app.AppCompatDelegate;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;


public class BaseApp extends Application {
    private static BaseApp sBaseApp;
    public static int widthPixels;
    public static int heightPixels;

    @Override
    public void onCreate() {
        super.onCreate();
        sBaseApp = this;
        getScreesWH();
    }

    public static BaseApp getInstance(){
        return sBaseApp;
    }


    public void getScreesWH() {
        WindowManager systemService = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display defaultDisplay = systemService.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        widthPixels = displayMetrics.widthPixels;
        heightPixels = displayMetrics.heightPixels;

    }
}
