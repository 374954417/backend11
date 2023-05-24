package com.example.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.entity.*;
import com.example.backend.mapper.HotelMapper;
import com.example.backend.mapper.OrderMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@Tag(name = "订单接口", description = "订单有关响应")
public class OrderController {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private HotelMapper hotelMapper;
    @CrossOrigin(value="http://localhost:8080")
    @PostMapping("/living/room/confirm")
    @Operation(summary = "订单提交",description = "接受Order对象，插入数据库")
    public ReturnMsg OrderRequest(@RequestBody Order order) {
        System.out.println("this");
        System.out.println(order.getOid());
        System.out.println(order.getUid());
        int a=orderMapper.insert(order);
        if(a>0) {
            return new ReturnMsg(405, "reserve success!");
        }
        else {
            return new ReturnMsg(406, "unknown error!");
        }
    }


    @CrossOrigin(value="http://localhost:8080")
    @PostMapping("/user/order")
    @Operation(summary = "订单查询",description = "接受User对象，查询所有订单")
    public ReturnMsg OrderRequest(@RequestBody User user) {
//        System.out.println("this");
//        System.out.println(order.getOid());
//        System.out.println(order.getUid());
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid",user.getUname());
        System.out.println(user.getUname());
        System.out.println(user.getUid());
        List<Order> orders= orderMapper.selectList(queryWrapper);

        List<OrderWithImg> orderWithImgs = new ArrayList<>();
        for (Order order : orders) {
            QueryWrapper<Hotel> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("hid", order.getHid());
            List<Hotel> hotel1 = hotelMapper.selectList(queryWrapper1);

            System.out.println(order.getOid());
            System.out.println(order.getEnddate());

            OrderWithImg temp = new OrderWithImg();
            temp.setAmount(order.getTotalprice());
            temp.setEndDate(order.getEnddate());
            temp.setId(String.valueOf(order.getOid()));
            temp.setHotel(hotel1.get(0).getHname());
            temp.setLocation(hotel1.get(0).getHaddress());
            temp.setImage(hotel1.get(0).getLargeImg());
            temp.setStartDate(order.getBegindate());

            orderWithImgs.add(temp);

        }
        return new ReturnMsg(408, "order query success!",orderWithImgs);
    }


    @CrossOrigin(value="http://localhost:8080")
    @PostMapping("/user/deleteorder")
    @Operation(summary = "订单删除",description = "接受Order对象，删除对应订单")
    public ReturnMsg DeleteOrder(@RequestBody Order order)
    {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("oid",order.getOid());
        orderMapper.deleteByMap(objectObjectHashMap);
        return new ReturnMsg(409, "order delete success!");

    }


}
