package com.garyhu.exploseview.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 作者： garyhu.
 * 时间： 2017/2/18.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
