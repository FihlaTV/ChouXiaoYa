package com.tiaozhanbei.chouxiaoya.bean;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class ClassBean implements Serializable {

    private Drawable mDrawable;
    private String name;

    public ClassBean(Drawable mDrawable, String name) {
        this.mDrawable = mDrawable;
        this.name = name;
    }

    public Drawable getmDrawable() {
        return mDrawable;
    }

    public void setmDrawable(Drawable mDrawable) {
        this.mDrawable = mDrawable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClassBean{" +
                "mDrawable=" + mDrawable +
                ", name='" + name + '\'' +
                '}';
    }
}
