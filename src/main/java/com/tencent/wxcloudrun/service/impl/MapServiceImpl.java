package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.common.MapInfo;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dao.MapMapper;
import com.tencent.wxcloudrun.dto.RoleWalkDTO;
import com.tencent.wxcloudrun.model.MapRole;
import com.tencent.wxcloudrun.service.MapService;
import com.tencent.wxcloudrun.vo.MapRoomVO;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.MapKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MapServiceImpl implements MapService {

    private final String finalMapRoom = "9";

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

    @Override
    public ApiResponse validTime(RoleWalkDTO walkInfo) {
        MapRole lastMapRole = mapMapper.getLastMapRoom(Integer.valueOf(walkInfo.getRoomId()), Integer.valueOf(walkInfo.getRoleId()));
        Integer lastArrivedTime;
        Integer lastMapRoom;
        if (Objects.isNull(lastMapRole)) {
            lastArrivedTime = 0;
            lastMapRoom = Integer.valueOf(MapInfo.roleStartPosition.get(walkInfo.getRoleId()));
        } else {
            lastArrivedTime = lastMapRole.getArrivedTime();
            lastMapRoom = lastMapRole.getMapRoom();
            if ((lastArrivedTime==60) || (lastArrivedTime+5==60)) {
                return ApiResponse.error("您的时间已耗尽，不可以前往任何地点");
            }
        }
        //当前玩家选中房间耗时
        Integer timeCost = MapInfo.mapRoomTimeCost.get(lastMapRoom.toString()).get(walkInfo.getToMapRoom());
        //到达当前选中房间后前往终点耗时
        Integer finalTimeCost;
        //两次路程总耗时
        int currentArrivedTime;
        if (finalMapRoom.equals(walkInfo.getToMapRoom())) {
            //如果前往终点可以不算搜索时间
            currentArrivedTime = lastArrivedTime+5+timeCost;
        } else {
            finalTimeCost = MapInfo.mapRoomTimeCost.get(walkInfo.getToMapRoom()).get(finalMapRoom);
            currentArrivedTime = lastArrivedTime+5+timeCost+5+finalTimeCost;
        }

        if (currentArrivedTime>60) {
            List<String> canGoRoom = new ArrayList<>();
            HashMap<String, Integer> goMap = MapInfo.mapRoomTimeCost.get(lastMapRoom.toString());
            //假设前往的房间号
            String toRoom;
            for (Map.Entry<String, Integer> entry : goMap.entrySet()) {
                toRoom = entry.getKey();
                timeCost = entry.getValue();
                if (finalMapRoom.equals(toRoom)) {
                    //如果前往终点可以不算搜索时间
                    currentArrivedTime = lastArrivedTime+5+timeCost;
                } else {
                    finalTimeCost = MapInfo.mapRoomTimeCost.get(toRoom).get(finalMapRoom);
                    currentArrivedTime = lastArrivedTime+5+timeCost+5+finalTimeCost;
                }
                if (currentArrivedTime<=60) {
                    canGoRoom.add(toRoom);
                }
            }
            return ApiResponse.error(
                    "前往"+MapInfo.mapRoomNum.get(walkInfo.getToMapRoom())+"后，剩余时间不足以前往"+MapInfo.mapRoomNum.get(finalMapRoom)
                            +"\n您当前可以前往的房间有：\n"+list2String(canGoRoom));
        } else {
            return ApiResponse.ok("前往"+MapInfo.mapRoomNum.get(walkInfo.getToMapRoom())+"需耗时："+timeCost+"分钟\n请合理分配时间");
        }
    }

    private String list2String(List<String> canGoRoomNumList){
        StringBuilder res = new StringBuilder();
        for (int i=0; i<canGoRoomNumList.size(); i++) {
            String canGoRoomNum = canGoRoomNumList.get(i);
            if (i==0) {
                res.append(MapInfo.mapRoomNum.get(canGoRoomNum));
            } else {
                res.append("，").append(MapInfo.mapRoomNum.get(canGoRoomNum));
            }
        }
        return res.toString();
    }

}
