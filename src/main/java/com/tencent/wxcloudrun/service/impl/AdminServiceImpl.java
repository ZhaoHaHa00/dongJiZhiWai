package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dao.AdminMapper;
import com.tencent.wxcloudrun.model.Admin;
import com.tencent.wxcloudrun.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public ApiResponse getAllAdmin() {
        List<Admin> adminList = adminMapper.getAllAdmin();
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
            adminMapper.insertAdmin(admin);
        } else {
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
