package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.LoginDTO;

public interface LoginService {

    ApiResponse login(LoginDTO loginDTO);
}
