package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.config.ApiResponse;

public interface MapService {

    ApiResponse getRolePosition(String roomId, String roleId);

    ApiResponse getAllMapRoomInfo();
}
