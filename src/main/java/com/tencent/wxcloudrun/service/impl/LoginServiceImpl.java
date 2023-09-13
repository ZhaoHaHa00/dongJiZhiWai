package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dao.AdminMapper;
import com.tencent.wxcloudrun.dto.LoginDTO;
import com.tencent.wxcloudrun.model.Admin;
import com.tencent.wxcloudrun.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public ApiResponse login(LoginDTO loginDTO) {
        List<Admin> adminList = adminMapper.getAdminInfo(loginDTO);
        if (CollectionUtils.isEmpty(adminList)) {
            return ApiResponse.error("0");
        }

        Admin admin = adminList.get(0);
        return ApiResponse.ok(admin.getType().toString(), admin);
    }
}
