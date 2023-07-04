package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dao.RoomMapper;
import com.tencent.wxcloudrun.dto.InsertRoomDTO;
import com.tencent.wxcloudrun.model.Room;
import com.tencent.wxcloudrun.service.RoomService;
import com.tencent.wxcloudrun.vo.RoomVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public ApiResponse getAllRoom(String validNum) {
        List<Room> roomList = roomMapper.getAllRoom(validNum);
        List<RoomVO> resList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Room room : roomList) {
            RoomVO roomVO = new RoomVO();
            roomVO.setRoomNum(room.getRoomNum());
            roomVO.setCreatedTime(sdf.format(room.getCreatedTime()));
            resList.add(roomVO);
        }
        return ApiResponse.ok(resList);
    }

    @Override
    public ApiResponse insertRoom(InsertRoomDTO insertRoomDTO) {

        int storeCount = roomMapper.countStoreRoom(insertRoomDTO.getValidNum());
        if (storeCount>4) {
            return ApiResponse.error("最多五个房间");
        }

        Room oldRoom = roomMapper.getRoomByStoreRoom(insertRoomDTO);
        if (Objects.nonNull(oldRoom)) {
            return ApiResponse.error("房间号已存在");
        }

        Room insertRoom = new Room();
        insertRoom.setValidNum(insertRoomDTO.getValidNum());
        insertRoom.setRoomNum(insertRoomDTO.getRoomNum());
        insertRoom.setCreatedTime(new Date());
        roomMapper.insertRoom(insertRoom);
        return ApiResponse.ok();
    }

    @Override
    public ApiResponse deleteRoom(InsertRoomDTO deleteInfo) {
        roomMapper.deleteRoom(deleteInfo);
        return ApiResponse.ok();
    }

    @Override
    public ApiResponse validRoom(String validNum, String roomNum) {
        InsertRoomDTO insertRoomDTO = new InsertRoomDTO();
        insertRoomDTO.setValidNum(validNum);
        insertRoomDTO.setRoomNum(roomNum);
        Room room = roomMapper.getRoomByStoreRoom(insertRoomDTO);
        if (Objects.isNull(room)) {
            return ApiResponse.error("验证失败");
        }
        return ApiResponse.ok(room.getId().toString());
    }
}
