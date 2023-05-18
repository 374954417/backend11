package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("room")
public class Room {
    private String rid;

    private String hid;

    private String rname;

    private String shortDesc;

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid == null ? null : rid.trim();
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid == null ? null : hid.trim();
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname == null ? null : rname.trim();
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc == null ? null : shortDesc.trim();
    }
}