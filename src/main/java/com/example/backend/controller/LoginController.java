package com.example.backend.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "测试Controller", description = "这是描述")
public class LoginController {


    @GetMapping("/hello")
    @Operation(summary = "测试接口")
    public String index(@Parameter(name = "name", description = "名称") String name) {
        return "hello " + name;
    }

}
