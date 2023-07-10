package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.common.MapInfo;
import com.tencent.wxcloudrun.common.Utils;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dao.MapRoleMapper;
import com.tencent.wxcloudrun.dao.MapRoomMapper;
import com.tencent.wxcloudrun.dao.RoomMapper;
import com.tencent.wxcloudrun.dto.InsertRoomDTO;
import com.tencent.wxcloudrun.model.MapRole;
import com.tencent.wxcloudrun.model.MapRoom;
import com.tencent.wxcloudrun.model.Room;
import com.tencent.wxcloudrun.service.RoomService;
import com.tencent.wxcloudrun.vo.RoomDetailVO;
import com.tencent.wxcloudrun.vo.RoomVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private MapRoomMapper mapRoomMapper;

    @Autowired
    private MapRoleMapper mapRoleMapper;

    @Override
    public ApiResponse getAllRoom(String validNum) {
        List<Room> roomList = roomMapper.getAllRoom(validNum);
        List<RoomVO> resList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Room room : roomList) {
            RoomVO roomVO = new RoomVO();
            roomVO.setId(room.getId().toString());
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

        mapRoomMapper.insertMapRoom(insertRoom.getId());

        return ApiResponse.ok();
    }

    @Override
    public ApiResponse deleteRoom(InsertRoomDTO deleteInfo) {
        Room room = roomMapper.getRoomByStoreRoom(deleteInfo);
        roomMapper.deleteRoom(deleteInfo);
        mapRoomMapper.deleteByRoomId(room.getId());
        mapRoleMapper.deleteByRoomId(room.getId());
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

    @Override
    public ApiResponse getRoomDetail(String roomId) {
        List<RoomDetailVO> resList = new ArrayList<>();
        List<MapRole> allMapRole = mapRoleMapper.getAllByRoomId(Long.valueOf(roomId));
        List<MapRole> allMapRole1 = allMapRole.stream().filter(e->e.getRoleIndex()==1).collect(Collectors.toList());
        List<MapRole> allMapRole2 = allMapRole.stream().filter(e->e.getRoleIndex()==2).collect(Collectors.toList());
        handleDiffIndex(allMapRole1, resList, "1");
        handleDiffIndex(allMapRole2, resList, "2");

        if (resList.size()!=14) {
            List<Integer> allExistRoomNum = allMapRole.stream().map(MapRole::getMapRoom).distinct().collect(Collectors.toList());
            for (int i = 1; i<=14; i++) {
                if (!allExistRoomNum.contains(i)) {
                    String roomName = MapInfo.mapRoomNum.get(Integer.toString(i));
                    RoomDetailVO res = new RoomDetailVO();
                    res.setRoomName(roomName);
                    res.setGameClue("");
                    res.setGameTool("");
                    resList.add(res);
                }
            }
        }

        resList = resList.stream().sorted(Comparator.comparing(RoomDetailVO::getRoomName)).collect(Collectors.toList());
        return ApiResponse.ok(resList);
    }

    private void handleDiffIndex(List<MapRole> allMapRole, List<RoomDetailVO> resList, String roleIndex){
        Map<Integer,List<MapRole>> allRoleMap = allMapRole.stream().collect(Collectors.groupingBy(MapRole::getMapRoom));
        for (Map.Entry<Integer, List<MapRole>> entry : allRoleMap.entrySet()) {
            RoomDetailVO res = new RoomDetailVO();
            Integer mapRoomNum = entry.getKey();
            String mapRoomName = MapInfo.mapRoomNum.get(mapRoomNum.toString());
            res.setRoomName(mapRoomName);

            List<MapRole> roomRoleList =
                    entry.getValue().stream().sorted(Comparator.comparing(MapRole::getArrivedTime)).collect(Collectors.toList());
            List<Integer> arrivedTimeSortedList = roomRoleList.stream().map(MapRole::getArrivedTime).collect(Collectors.toList());
            ;
            MapRole toolMapRole = roomRoleList.get(Utils.getToolRoleNo(arrivedTimeSortedList)-1);
            String toolRoleName = MapInfo.roleInfo.get(toolMapRole.getRoleId().toString());
            String toolName = MapInfo.mapRoomTool.get("mapRoomClue"+mapRoomNum+"_"+roleIndex);
            if (StringUtils.isEmpty(toolName)) {
                res.setGameTool("");
            } else {
                res.setGameTool(toolRoleName+"获得了\n"+toolName);
            }

            StringBuilder gameClueSb = new StringBuilder();
            for (MapRole roomRole : roomRoleList) {
                gameClueSb.append(Utils.getExploreTimeStr(roomRole.getArrivedTime()))
                        .append(" ").append(MapInfo.roleInfo.get(roomRole.getRoleId().toString())).append("\n");
            }
            res.setGameClue(gameClueSb.toString());
            resList.add(res);
        }
    }

    //生成船长路线
    private void buildCaptainRoute(List<String> captainRoute, List<MapRole> allRoleInfo){
        //生成一个时间点-mapRoleList的map
        Map<Integer, List<MapRole>> timeMapRoleMap =
                allRoleInfo.stream().collect(Collectors.groupingBy(MapRole::getArrivedTime));
        //角色到达时间及到达时间后的5分钟都算作在当前房间，重构map
    }

    private void rebuildTimeMapRole(Map<Integer, List<MapRole>> timeMapRoleMap){}
}
