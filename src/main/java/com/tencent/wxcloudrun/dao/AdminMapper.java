package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.dto.LoginDTO;
import com.tencent.wxcloudrun.model.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper {

    List<Admin> getAdminInfo(@Param("loginDTO") LoginDTO loginDTO);

    List<Admin> getAllAdmin(@Param("storeName")String storeName, @Param("city")String city);

    void insertAdmin(@Param("admin")Admin admin);

    void updateAdmin(@Param("admin")Admin admin);

    void deleteAdmin(@Param("id") Integer id);

    Admin validNewItem(@Param("validNum") String validNum, @Param("username")String username);

    Admin validOldItem(@Param("oldNum") String oldNum, @Param("newNum") String newNum, @Param("oldUsername")String oldUsername,
                       @Param("newUsername")String newUsername);

    Admin getAdminInfoById(@Param("id") Long id);
}
