package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.common.ServiceResponse;
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
    public ServiceResponse<String> login(LoginDTO loginDTO) {
        Admin admin = adminMapper.getAdminInfo(loginDTO);
        if (Objects.isNull(admin)) {
            return new ServiceResponse<>(88, "0", null);
        }
        return new ServiceResponse<>(88, admin.getType().toString(), null);
    }
}
