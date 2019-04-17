package com.tiaozhanbei.chouxiaoya.bean;

import android.graphics.drawable.Drawable;

public class CosmeticsBean {

    private Drawable mDrawable;
    private String name;

    public CosmeticsBean(Drawable mDrawable, String name) {
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
}
