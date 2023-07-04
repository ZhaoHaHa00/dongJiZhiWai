package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.MapRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MapMapper {

    MapRole getLastMapRoom(@Param("roomId")Integer roomId, @Param("roleId")Integer roleId);
}
