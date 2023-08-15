package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.dto.LoginDTO;
import com.tencent.wxcloudrun.model.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper {

    Admin getAdminInfo(@Param("loginDTO") LoginDTO loginDTO);

    List<Admin> getAllAdmin(@Param("storeName")String storeName, @Param("city")String city);

    void insertAdmin(@Param("admin")Admin admin);

    void updateAdmin(@Param("admin")Admin admin);

    void deleteAdmin(@Param("id") Integer id);

    Admin validNewItemNum(@Param("validNum") String validNum);

    Admin validOldItemNum(@Param("oldNum") String oldNum, @Param("newNum") String newNum);

    Admin getAdminInfoById(@Param("id") Long id);
}
