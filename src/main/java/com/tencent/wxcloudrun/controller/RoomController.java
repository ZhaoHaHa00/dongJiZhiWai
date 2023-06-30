package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.InsertRoomDTO;
import com.tencent.wxcloudrun.service.RoomService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/all")
    public ApiResponse getAllRoom(@RequestParam("validNum") String validNum){
        return roomService.getAllRoom(validNum);
    }

    @PostMapping("/insert")
    public ApiResponse insertRoom(@RequestBody InsertRoomDTO insertRoomDTO){
        return roomService.insertRoom(insertRoomDTO);
    }

    @PostMapping("/delete")
    public ApiResponse deleteRoom(@RequestBody InsertRoomDTO insertRoomDTO){
        return roomService.deleteRoom(insertRoomDTO);
    }

    @GetMapping("/valid")
    public ApiResponse validRoom(@Param("validNum")String validNum, @Param("roomNum")String roomNum){
        return roomService.validRoom(validNum, roomNum);
    }
}
