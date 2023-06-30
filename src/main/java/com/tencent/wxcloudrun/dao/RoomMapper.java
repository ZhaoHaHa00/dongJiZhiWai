package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoomMapper {

    List<Room> getAllRoom(@Param("validNum") String validNum);
}
