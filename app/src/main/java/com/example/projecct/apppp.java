package com.example.projecct;

import android.app.Application;
import android.os.SystemClock;
public class apppp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(1000);
    }
}

