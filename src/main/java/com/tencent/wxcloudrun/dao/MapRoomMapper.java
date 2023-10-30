package com.tencent.wxcloudrun.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MapRoomMapper {

    void insertMapRoom(@Param("roomId")Long roomId);

    void deleteByRoomId(@Param("roomId")Long roomId);

    Integer getStateByRoomId(@Param("roomId")Long roomId);

    void finishAllByRoomId(@Param("roomId")Long roomId);
}
