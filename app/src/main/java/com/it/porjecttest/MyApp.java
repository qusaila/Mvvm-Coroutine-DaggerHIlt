package com.it.porjecttest;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class MyApp extends Application {
    static MyApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
    }

    public static MyApp getInstance(){
        return app;
    }
}
