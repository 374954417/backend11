package com.example.backend.entity;


import com.baomidou.mybatisplus.annotation.TableName;

@TableName("subroom")
public class Subroom {
    private String srid;

    private String rid;

    private String price;

    private String pnum;

    private String feature1;

    private String feature2;

    private String feature3;

    public String getSrid() {
        return srid;
    }

    public void setSrid(String srid) {
        this.srid = srid == null ? null : srid.trim();
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid == null ? null : rid.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getPnum() {
        return pnum;
    }

    public void setPnum(String pnum) {
        this.pnum = pnum == null ? null : pnum.trim();
    }

    public String getFeature1() {
        return feature1;
    }

    public void setFeature1(String feature1) {
        this.feature1 = feature1 == null ? null : feature1.trim();
    }

    public String getFeature2() {
        return feature2;
    }

    public void setFeature2(String feature2) {
        this.feature2 = feature2 == null ? null : feature2.trim();
    }

    public String getFeature3() {
        return feature3;
    }

    public void setFeature3(String feature3) {
        this.feature3 = feature3 == null ? null : feature3.trim();
    }
}