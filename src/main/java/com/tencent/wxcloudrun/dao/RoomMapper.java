package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.dto.InsertRoomDTO;
import com.tencent.wxcloudrun.model.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoomMapper {

    List<Room> getAllRoom(@Param("validNum") String validNum);

    void insertRoom(@Param("insertInfo")Room room);

    Room getRoomByStoreRoom(@Param("insertInfo")InsertRoomDTO insertInfo);

    Integer countStoreRoom(@Param("validNum")String validNum);

    void deleteRoom(@Param("deleteInfo")InsertRoomDTO deleteInfo);
}
