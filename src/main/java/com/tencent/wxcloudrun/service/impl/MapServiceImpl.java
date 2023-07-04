package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.common.MapInfo;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dao.MapMapper;
import com.tencent.wxcloudrun.model.MapRole;
import com.tencent.wxcloudrun.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;

@Service
public class MapServiceImpl implements MapService {

    @Autowired
    private MapMapper mapMapper;

    @Override
    public ApiResponse getRolePosition(String roomId, String roleId) {
        MapRole mapRole = mapMapper.getLastMapRoom(Integer.valueOf(roomId), Integer.valueOf(roleId));
        if (Objects.isNull(mapRole)) {
            return ApiResponse.ok("room"+MapInfo.roleStartPosition.get(roleId));
        } else {
            return ApiResponse.ok("room"+mapRole.getMapRoom());
        }
    }
}
