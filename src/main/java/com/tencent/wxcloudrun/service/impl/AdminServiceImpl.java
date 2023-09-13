package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dao.AdminMapper;
import com.tencent.wxcloudrun.model.Admin;
import com.tencent.wxcloudrun.service.AdminService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public ApiResponse getAllAdmin(String storeName, String city) {
        List<Admin> adminList = adminMapper.getAllAdmin(storeName, city);
        for (Admin admin : adminList) {
            if (Objects.isNull(admin.getCity())) {
                admin.setCity("");
            }
            if (Objects.isNull(admin.getStoreName())) {
                admin.setStoreName("");
            }
        }
        return ApiResponse.ok(adminList);
    }

    @Override
    public ApiResponse updateAdmin(Admin admin) {

        admin.setType(2);
        if (Objects.isNull(admin.getId())) {

            List<Admin> validItemList = adminMapper.validNewItem(admin.getValidNum(), admin.getUsername());
            if (!CollectionUtils.isEmpty(validItemList)){
                Admin validItem = validItemList.get(0);
                if (admin.getUsername().equals(validItem.getUsername())) {
                    return ApiResponse.error("用户名已存在");
                }
                if (admin.getValidNum().equals(validItem.getValidNum())) {
                    return ApiResponse.error("编号已存在");
                }
            }

            adminMapper.insertAdmin(admin);
        } else {

            Admin oldItem = adminMapper.getAdminInfoById(admin.getId());
            List<Admin> validItemList = adminMapper.validOldItem(oldItem.getValidNum(), admin.getValidNum(),
                    oldItem.getUsername(), admin.getUsername());
            if (!CollectionUtils.isEmpty(validItemList)){
                Admin validItem = validItemList.get(0);
                if (admin.getUsername().equals(validItem.getUsername())) {
                    return ApiResponse.error("用户名已存在");
                }
                if (admin.getValidNum().equals(validItem.getValidNum())) {
                    return ApiResponse.error("编号已存在");
                }
            }

            adminMapper.updateAdmin(admin);
        }
        return ApiResponse.ok();
    }

    @Override
    public ApiResponse deleteAdmin(String id) {
        adminMapper.deleteAdmin(Integer.valueOf(id));
        return ApiResponse.ok();
    }
}
