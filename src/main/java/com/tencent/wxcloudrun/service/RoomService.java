package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.InsertRoomDTO;

public interface RoomService {

    ApiResponse getAllRoom(String validNum);

    ApiResponse insertRoom(InsertRoomDTO insertRoomDTO);

    ApiResponse deleteRoom(InsertRoomDTO deleteInfo);
}
