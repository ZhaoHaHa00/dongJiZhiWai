package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.InsertRoomDTO;
import org.apache.ibatis.annotations.Param;

public interface RoomService {

    ApiResponse getAllRoom(String validNum);

    ApiResponse insertRoom(InsertRoomDTO insertRoomDTO);

    ApiResponse deleteRoom(InsertRoomDTO deleteInfo);

    ApiResponse validRoom(String validNum, String roomNum);

    ApiResponse getRoomDetail(String roomId);
}
