package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.common.MapInfo;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dao.MapMapper;
import com.tencent.wxcloudrun.model.MapRole;
import com.tencent.wxcloudrun.service.MapService;
import com.tencent.wxcloudrun.vo.MapRoomVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @Override
    public ApiResponse getAllMapRoomInfo() {
        List<MapRoomVO> resList = new ArrayList<>();
        MapInfo.mapRoomNum.forEach((key, value) -> {
            MapRoomVO mapRoomVO = new MapRoomVO(key, value);
            resList.add(mapRoomVO);
        });
        return ApiResponse.ok(resList);
    }
}
