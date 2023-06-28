package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.common.ServiceResponse;
import com.tencent.wxcloudrun.dto.LoginDTO;
import com.tencent.wxcloudrun.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ServiceResponse<String> login(@RequestBody LoginDTO loginDTO){

        if (StringUtils.isEmpty(loginDTO.getUser()) || StringUtils.isEmpty(loginDTO.getPassword())) {
            return new ServiceResponse<>(88, "请完整填写账号密码", null);
        }

        return loginService.login(loginDTO);

    }
}
