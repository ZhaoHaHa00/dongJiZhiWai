package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.common.ServiceResponse;
import com.tencent.wxcloudrun.dto.LoginDTO;

public interface LoginService {

    ServiceResponse<String> login(LoginDTO loginDTO);
}
