package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("hotel")
public class Hotel {
    private String hid;

    private String hname;

    private String haddress;

    private String province;

    private String city;

    private String score;

    private String largeImg;

    private String midImg;

    private String midImg2;

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid == null ? null : hid.trim();
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname == null ? null : hname.trim();
    }

    public String getHaddress() {
        return haddress;
    }

    public void setHaddress(String haddress) {
        this.haddress = haddress == null ? null : haddress.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public String getLargeImg() {
        return largeImg;
    }

    public void setLargeImg(String largeImg) {
        this.largeImg = largeImg == null ? null : largeImg.trim();
    }

    public String getMidImg() {
        return midImg;
    }

    public void setMidImg(String midImg) {
        this.midImg = midImg == null ? null : midImg.trim();
    }

    public String getMidImg2() {
        return midImg2;
    }

    public void setMidImg2(String midImg2) {
        this.midImg2 = midImg2 == null ? null : midImg2.trim();
    }
}