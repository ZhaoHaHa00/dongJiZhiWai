package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.common.ServiceResponse;
import com.tencent.wxcloudrun.dto.LoginDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public ServiceResponse<String> login(@RequestBody LoginDTO loginDTO){

        System.out.println(loginDTO.getUser());
        System.out.println(loginDTO.getPassword());

        if (StringUtils.isEmpty(loginDTO.getUser()) || StringUtils.isEmpty(loginDTO.getPassword())) {
            return new ServiceResponse<>(88, "请完整填写账号密码", null);
        }

        if ("admin".equals(loginDTO.getUser()) && "admin".equals(loginDTO.getPassword())) {
            return new ServiceResponse<>(0, "1", null);
        }

        return new ServiceResponse<>(0, "2", null);
    }
}
