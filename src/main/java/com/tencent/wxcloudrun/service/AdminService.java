package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.Admin;

public interface AdminService {

    ApiResponse getAllAdmin();

    ApiResponse updateAdmin(Admin admin);

    ApiResponse deleteAdmin(String id);
}
