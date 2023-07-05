package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.service.MapService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/map")
public class MapController {

    @Autowired
    private MapService mapService;

    @GetMapping("/role/position")
    public ApiResponse getRolePosition(@Param("roomId") String roomId, @Param("roleId")String roleId){
        return mapService.getRolePosition(roomId, roleId);
    }

//    @PostMapping("/role/walk")
//    public ApiResponse roleWalk(@RequestBody ){}

    @GetMapping("/room/all")
    public ApiResponse getAllMapRoomInfo(){
        return mapService.getAllMapRoomInfo();
    }
}
