package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.LoginDTO;
import com.tencent.wxcloudrun.service.AdminService;
import com.tencent.wxcloudrun.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ApiResponse login(@RequestBody LoginDTO loginDTO){

        if (StringUtils.isEmpty(loginDTO.getUser()) || StringUtils.isEmpty(loginDTO.getPassword())) {
            return ApiResponse.error("请完整填写账号密码");
        }

        return loginService.login(loginDTO);

    }

    @GetMapping("/all")
    public ApiResponse getAllAdmin(){
        return adminService.getAllAdmin();
    }
}
