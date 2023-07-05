package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.RoleWalkDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface MapService {

    ApiResponse getRolePosition(String roomId, String roleId);

    ApiResponse getAllMapRoomInfo();

    ApiResponse validTime(RoleWalkDTO walkInfo);

    ApiResponse roleWalk(RoleWalkDTO walkInfo);
}
