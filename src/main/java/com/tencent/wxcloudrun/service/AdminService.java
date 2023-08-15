package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.Admin;

public interface AdminService {

    ApiResponse getAllAdmin(String storeName, String city);

    ApiResponse updateAdmin(Admin admin);

    ApiResponse deleteAdmin(String id);
}
