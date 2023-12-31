package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.LoginDTO;
import com.tencent.wxcloudrun.model.Admin;
import com.tencent.wxcloudrun.service.AdminService;
import com.tencent.wxcloudrun.service.LoginService;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ApiResponse login(@RequestBody LoginDTO loginDTO){

        if (StringUtils.isEmpty(loginDTO.getUser()) || StringUtils.isEmpty(loginDTO.getPassword())) {
            return ApiResponse.error("账号/密码错误");
        }

        return loginService.login(loginDTO);

    }

    @GetMapping("/all")
    public ApiResponse getAllAdmin(@RequestParam(required = false)String storeName,
                                   @RequestParam(required = false)String city){
        return adminService.getAllAdmin(storeName, city);
    }

    @PostMapping("/update")
    public ApiResponse updateAdmin(@RequestBody Admin admin){
        String usernameRegex = "^[0-9a-zA-Z]{4,16}$";
        String passwordRegex = "^[0-9a-zA-Z]{6,18}$";
        String validNumRegex = "^[0-9]{4}$";

        String username = admin.getUsername();
        if (StringUtils.isEmpty(username)){
            return ApiResponse.error("用户名不可为空");
        }
        if (!username.matches(usernameRegex)){
            return ApiResponse.error("用户名不合规");
        }

        String password = admin.getPassword();
        if (StringUtils.isEmpty(password)){
            return ApiResponse.error("密码不可为空");
        }
        if (!password.matches(passwordRegex)) {
            return ApiResponse.error("密码不合规");
        }

        String validNum = admin.getValidNum();
        if (StringUtils.isEmpty(validNum)) {
            return ApiResponse.error("编号不可为空");
        }
        if (!validNum.matches(validNumRegex)) {
            return ApiResponse.error("编号不合规");
        }

        return adminService.updateAdmin(admin);
    }

    @GetMapping("/delete")
    public ApiResponse deleteAdmin(@RequestParam String id){
        return adminService.deleteAdmin(id);
    }

}
