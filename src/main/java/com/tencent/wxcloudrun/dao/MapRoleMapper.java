package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.MapRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MapRoleMapper {

    MapRole getLastMapRoom(@Param("roomId")Long roomId, @Param("roleId")Integer roleId);

    void deleteByRoomId(@Param("roomId")Long roomId);

    void insertMapRole(@Param("mapRole")MapRole mapRole);

    List<MapRole> getOtherRoleByRoomId(@Param("roomId")Long roomId, @Param("roleId") Integer roleId);

    List<MapRole> getAllIndex(@Param("roomId")Long roomId, @Param("roleIndex")Integer roleIndex);
}
