package com.example.backend.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.backend.entity.ReturnMsg;
import com.example.backend.entity.User;
import com.example.backend.mapper.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@Tag(name = "用户接口", description = "用户账号有关响应")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @CrossOrigin(value="http://localhost:8080")
    @GetMapping("/user")
    @Operation(summary = "测试接口")
    public List<User> query() {
        List<User> list= userMapper.find();
        System.out.println(list);
        return list;
    }

    @CrossOrigin(value="http://localhost:8080")
    @PostMapping("/login/login")
    @Operation(summary = "登录请求",description = "接受User对象。账号不存在返回101，密码错误返回102，登陆成功返回103。（该方法只检查uname和pwd，其余字段可填任意值。）")
    public ReturnMsg Login(@RequestBody User user) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uname",user.getUname());
        System.out.println(user.getUname());
        System.out.println(user.getUid());
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

    @CrossOrigin(value="http://localhost:8080")
    @PostMapping("/login/register")
    @Operation(summary = "注册请求",description = "接受User对象。账号存在返回104，注册成功返回105，未知错误返回106。")
    public ReturnMsg Register(@RequestBody User user) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uname",user.getUname());
        System.out.println(user.getUname());
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


    @CrossOrigin(value="http://localhost:8080")
    @PostMapping("/user/changepwd")
    @Operation(summary = "更改密码请求",description = "接受User对象。密码错误返回107，更改成功返回108。")
    public ReturnMsg ChangePassWord(@RequestBody User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uname",user.getUname());
        List<User> userquery= userMapper.selectList(queryWrapper);
        if(!Objects.equals(userquery.get(0).getPwd(), user.getPhone_number()))
        {
            return new ReturnMsg(107, "old pwd not match!");
        }
        else
        {
            UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("uname",user.getUname()).set("pwd",user.getPwd());
            userMapper.update(null,updateWrapper);
            return new ReturnMsg(108, "change success!");
        }
    }

}
//    @GetMapping("/hello")
//    @Operation(summary = "测试接口")
//    public String index(@Parameter(name = "name", description = "名称") String name) {
//        return "hello " + name;
//    }