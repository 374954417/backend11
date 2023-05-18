package com.example.backend.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.entity.*;
import com.example.backend.mapper.RoomMapper;
import com.example.backend.mapper.SubroomMapper;
import com.example.backend.mapper.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@Tag(name = "用户接口", description = "用户账号有关响应")
public class RoomController {
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private SubroomMapper subroomMapper;

    @PostMapping("/living/room")
    @Operation(summary = "房间信息请求",description = "接受Hotel对象。根据hid查找相应房间")
    public ReturnMsg RoomRequest(Hotel hotel) {

        List<RoomObj> roomObjs=new ArrayList<>();

        QueryWrapper<Room> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hid",hotel.getHid());
        List<Room> rooms= roomMapper.selectList(queryWrapper);
        for (Room room : rooms) {
            QueryWrapper<Subroom> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("rid", room.getRid());
            List<Subroom> subrooms = subroomMapper.selectList(queryWrapper1);
            RoomObj temp = new RoomObj(room, subrooms);
            roomObjs.add(temp);
        }
        return new ReturnMsg(3010,"room search success!",roomObjs);



    }




}
//    @GetMapping("/hello")
//    @Operation(summary = "测试接口")
//    public String index(@Parameter(name = "name", description = "名称") String name) {
//        return "hello " + name;
//    }