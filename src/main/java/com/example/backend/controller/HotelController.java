package com.example.backend.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.entity.Hotel;
import com.example.backend.entity.ReturnMsg;
import com.example.backend.mapper.HotelMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@Tag(name = "用户接口", description = "用户账号有关响应")
public class HotelController {
    @Autowired
    private HotelMapper hotelMapper;

    @CrossOrigin(value="http://localhost:8080")
    @GetMapping("/living")
    @Operation(summary = "酒店搜索请求",description = "接受url参数。分别为搜索目的地，checkin日期和checkout日期（日期暂时可以不写）。")
    public ReturnMsg HotelRequest(@RequestParam(value = "target") String target, @RequestParam(value = "checkin",required = false) Date checkin,@RequestParam(value = "checkout",required = false) Date checkout)
    {
        QueryWrapper<Hotel> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("city",target);
        List<Hotel> hotelList= hotelMapper.selectList(queryWrapper);
        return new ReturnMsg(201,"search success!",hotelList);
    }


}
//    @GetMapping("/hello")
//    @Operation(summary = "测试接口")
//    public String index(@Parameter(name = "name", description = "名称") String name) {
//        return "hello " + name;
//    }