package com.example.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.entity.Hotel;
import com.example.backend.entity.Order;
import com.example.backend.entity.ReturnMsg;
import com.example.backend.entity.User;
import com.example.backend.mapper.OrderMapper;
import com.example.backend.mapper.RoomMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "订单接口", description = "订单有关响应")
public class OrderController {
    @Autowired
    private OrderMapper orderMapper;
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
}
