package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.RoleWalkDTO;
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

    @PostMapping("/time/valid")
    public ApiResponse validTime(@RequestBody RoleWalkDTO walkInfo){
        return mapService.validTime(walkInfo);
    }

    @GetMapping("/room/all")
    public ApiResponse getAllMapRoomInfo(){
        return mapService.getAllMapRoomInfo();
    }

    @PostMapping("/role/walk")
    public ApiResponse roleWalk(@RequestBody RoleWalkDTO walkDTO){
        return mapService.roleWalk(walkDTO);
    }

    @GetMapping("/role/clue")
    public ApiResponse getRoleClue(@Param("roomId")String roomId, @Param("")String roleId){
        return mapService.getRoleClue(roomId, roleId);
    }
}
