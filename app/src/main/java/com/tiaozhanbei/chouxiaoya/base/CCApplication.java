package com.tiaozhanbei.chouxiaoya.base;

import android.app.Activity;
import android.app.Application;

import com.blankj.utilcode.util.Utils;


public class CCApplication extends Application {

    private static final String TAG = CCApplication.class.getSimpleName();

    private static CCApplication INSTANCE;
    private volatile Activity mCurrentActivity;
    private boolean mIsInForeground = false;

    public static CCApplication getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        Utils.init(this);
    }
}