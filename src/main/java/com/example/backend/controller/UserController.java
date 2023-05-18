package com.example.backend.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.entity.ReturnMsg;
import com.example.backend.entity.User;
import com.example.backend.mapper.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@Tag(name = "用户接口", description = "用户账号有关响应")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/user")
    @Operation(summary = "测试接口")
    public List<User> query() {
        List<User> list= userMapper.find();
        System.out.println(list);
        return list;
    }


    @PostMapping("/login/login")
    @Operation(summary = "登录请求",description = "接受User对象。账号不存在返回101，密码错误返回102，登陆成功返回103。（该方法只检查uname和pwd，其余字段可填任意值。）")
    public ReturnMsg Login(User user) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uname",user.getUname());
        List<User> user1= userMapper.selectList(queryWrapper);
        if(user1.isEmpty())
        {
            return new ReturnMsg(101, "uname not exist!");
        }

        if(!Objects.equals(user1.get(0).getPwd(), user.getPwd())){
            return new ReturnMsg(102, "pwd not match!");
        }
        return new ReturnMsg(103, "login success!");
    }


    @PostMapping("/login/register")
    @Operation(summary = "注册请求",description = "接受User对象。账号存在返回104，注册成功返回105，未知错误返回106。")
    public ReturnMsg Register(User user) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uname",user.getUname());
        List<User> user1= userMapper.selectList(queryWrapper);
        if(!user1.isEmpty())
        {
            return new ReturnMsg(104, "uname has existed!");
        }

        int a=userMapper.insert(user);

        if(a>0) {
            return new ReturnMsg(105, "register success!");
        }
        else {
            return new ReturnMsg(106, "unknown error!");
        }
    }

}
//    @GetMapping("/hello")
//    @Operation(summary = "测试接口")
//    public String index(@Parameter(name = "name", description = "名称") String name) {
//        return "hello " + name;
//    }