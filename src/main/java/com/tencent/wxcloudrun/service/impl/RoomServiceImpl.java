package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dao.RoomMapper;
import com.tencent.wxcloudrun.model.Room;
import com.tencent.wxcloudrun.service.RoomService;
import com.tencent.wxcloudrun.vo.RoomVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
}
