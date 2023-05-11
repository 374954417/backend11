package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("user")
public class User {
    private int uid;
    private String uname;


    public int getId() {
        return uid;
    }

    public void setId(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return uname;
    }

    public void setUsername(String uname) {
        this.uname = uname;
    }


}
