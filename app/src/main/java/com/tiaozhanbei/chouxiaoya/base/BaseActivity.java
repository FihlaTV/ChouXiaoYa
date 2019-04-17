package com.tiaozhanbei.chouxiaoya.base;


import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.gyf.barlibrary.ImmersionBar;
import com.gyf.barlibrary.OSUtils;

import java.util.List;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    protected Handler mHandler;

    private InputMethodManager mInputMethodManager;

    // 当前activity是否是前台运行状态
    public boolean isForegroundRunning = false;

    // 当前app是否是前台状态
    private static boolean isActive = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isForegroundRunning = false;
        //初始化沉浸式
        if (isImmersionBarEnabled()) {
            initImmersionBar();
        }
    }

    public Handler getHandler() {
        if (mHandler == null) {
            synchronized (this) {
                if (mHandler == null) {
                    mHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        return mHandler;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    public void doInUI(Runnable runnable) {
        doInUI(runnable, 0);
    }

    public void doInUI(Runnable runnable, long delayMillis) {
        getHandler().postDelayed(runnable, delayMillis);
    }

    public void toActivity(Class<? extends Activity> clazz) {
        startActivity(new Intent(this, clazz));
    }

    @Override
    protected void onResume() {
        super.onResume();
        isForegroundRunning = true;
        if (!isActive) {
            //app 从后台唤醒，进入前台
            isActive = true;
        }
        // 非必加
        // 如果你的app可以横竖屏切换，适配了华为emui3系列系统手机，并且navigationBarWithEMUI3Enable为true，
        // 请在onResume方法里添加这句代码（同时满足这三个条件才需要加上代码哦：1、横竖屏可以切换；2、华为emui3系列系统手机；3、navigationBarWithEMUI3Enable为true）
        // 否则请忽略
        if (OSUtils.isEMUI3_x() && isImmersionBarEnabled()) {
            ImmersionBar.with(this).init();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        isForegroundRunning = false;
    }

    @Override
    protected void onStop() {
        super.onStop();
        isForegroundRunning = false;

        if (!isAppOnForeground()) {
            isActive = false;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mInputMethodManager = null;
        if (isImmersionBarEnabled()) {
            ImmersionBar.with(this).destroy();
        }
    }

    protected void initImmersionBar() {
        //在BaseActivity里初始化
        ImmersionBar.with(this).init();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (isImmersionBarEnabled()) {
            // 非必加
            // 如果你的app可以横竖屏切换，适配了4.4或者华为emui3.1系统手机，并且navigationBarWithKitkatEnable为true，
            // 请务必在onConfigurationChanged方法里添加如下代码（同时满足这三个条件才需要加上代码哦：1、横竖屏可以切换；2、android4.4或者华为emui3.1系统手机；3、navigationBarWithKitkatEnable为true）
            // 否则请忽略
            ImmersionBar.with(this).init();
        }
    }

    /**
     * 是否可以使用沉浸式
     * Is immersion bar enabled boolean.
     *
     * @return the boolean
     */
    protected boolean isImmersionBarEnabled() {
        return true;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        isForegroundRunning = false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public <V extends View> V findView(int id) {
        return (V) findViewById(id);
    }

    public String getClassName() {
        return getClass().getSimpleName();
    }

    /**
     * 程序是否在前台运行
     *
     * @return
     */
    private boolean isAppOnForeground() {
        // Returns a list of application processes that are running on the device
        ActivityManager activityManager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        String packageName = getApplicationContext().getPackageName();

        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager
                .getRunningAppProcesses();
        if (appProcesses == null) {
            return false;
        }

        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            // The name of the process that this object is associated with.
            if (appProcess.processName.equals(packageName)
                    && appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Activity getActivityContext() {
        return this;
    }

    @Override
    public void setPresenter(Object presenter) {

    }

    @Override
    public void finish() {
        super.finish();
        hideSoftKeyBoard();
    }


    public void hideSoftKeyBoard() {
        View localView = getCurrentFocus();
        if (this.mInputMethodManager == null) {
            this.mInputMethodManager = ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE));
        }
        if ((localView != null) && (this.mInputMethodManager != null)) {
            this.mInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 2);
        }
    }
}
