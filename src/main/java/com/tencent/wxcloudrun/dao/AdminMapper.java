package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.dto.LoginDTO;
import com.tencent.wxcloudrun.model.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper {

    Admin getAdminInfo(@Param("loginDTO") LoginDTO loginDTO);

    List<Admin> getAllAdmin();
}
