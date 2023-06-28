package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dao.AdminMapper;
import com.tencent.wxcloudrun.dto.LoginDTO;
import com.tencent.wxcloudrun.model.Admin;
import com.tencent.wxcloudrun.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public ApiResponse login(LoginDTO loginDTO) {
        Admin admin = adminMapper.getAdminInfo(loginDTO);
        if (Objects.isNull(admin)) {
            return ApiResponse.error("0");
        }
        return ApiResponse.ok(admin.getType().toString());
    }
}
