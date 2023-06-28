package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
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
    public ApiResponse login(@RequestBody LoginDTO loginDTO){

        if (StringUtils.isEmpty(loginDTO.getUser()) || StringUtils.isEmpty(loginDTO.getPassword())) {
            return ApiResponse.error("请完整填写账号密码");
        }

        return loginService.login(loginDTO);

    }
}
