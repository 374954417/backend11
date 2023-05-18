package com.example.backend.mapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.backend.entity.Hotel;
import com.example.backend.entity.Room;
import com.example.backend.entity.Subroom;
import com.example.backend.entity.User;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface SubroomMapper extends BaseMapper<Subroom> {
}
