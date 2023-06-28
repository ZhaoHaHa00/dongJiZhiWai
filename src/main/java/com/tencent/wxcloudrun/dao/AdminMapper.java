package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.dto.LoginDTO;
import com.tencent.wxcloudrun.model.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    Admin getAdminInfo(LoginDTO loginDTO);
}
