package com.yuy.recyclerviewdemo;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.yuy.recyclerviewdemo.utils.Utils;

/**
 * Author: yuyang
 * Date:2019/6/25 23:41
 */
public class MyApplication extends Application {

    private static MyApplication appContext;

    public static MyApplication getInstance() {
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        Utils.init(this);
        if (BuildConfig.DEBUG) {
            Logger.addLogAdapter(new AndroidLogAdapter());


        }
    }
}
