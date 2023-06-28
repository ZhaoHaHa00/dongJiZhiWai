package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dao.AdminMapper;
import com.tencent.wxcloudrun.model.Admin;
import com.tencent.wxcloudrun.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public ApiResponse getAllAdmin() {
        List<Admin> adminList = adminMapper.getAllAdmin();
        return ApiResponse.ok(adminList);
    }
}
