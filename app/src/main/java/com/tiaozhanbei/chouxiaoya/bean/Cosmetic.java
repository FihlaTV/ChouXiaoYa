package com.tiaozhanbei.chouxiaoya.bean;

/**
 * Created by SailFlorve on 2017/11/19 0019.
 * 化妆品实体类
 */

public class Cosmetic {
    private String name;
    private String des;
    private int imageId;

    public Cosmetic(String name, String des, int imageId) {
        this.name = name;
        this.des = des;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }


    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
