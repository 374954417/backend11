package com.example.backend.controller;


import com.example.backend.entity.User;
import com.example.backend.mapper.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "测试Controller", description = "这是描述")
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

}
//    @GetMapping("/hello")
//    @Operation(summary = "测试接口")
//    public String index(@Parameter(name = "name", description = "名称") String name) {
//        return "hello " + name;
//    }