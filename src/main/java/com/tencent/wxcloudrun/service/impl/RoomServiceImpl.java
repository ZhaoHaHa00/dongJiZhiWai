package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.common.MapInfo;
import com.tencent.wxcloudrun.common.Utils;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dao.MapRoleMapper;
import com.tencent.wxcloudrun.dao.MapRoomMapper;
import com.tencent.wxcloudrun.dao.RoomMapper;
import com.tencent.wxcloudrun.dto.InsertRoomDTO;
import com.tencent.wxcloudrun.model.MapRole;
import com.tencent.wxcloudrun.model.Room;
import com.tencent.wxcloudrun.service.RoomService;
import com.tencent.wxcloudrun.vo.RoomVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.xml.transform.Source;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static com.tencent.wxcloudrun.common.Utils.captainName;

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
        List<List<String>> resList = new ArrayList<>();
        List<MapRole> allMapRole = mapRoleMapper.getAllByRoomId(Long.valueOf(roomId));
        handleCaptainRoute(resList);
        handleRoleRoute(allMapRole, resList);
        handleGameTool(allMapRole, resList);

//        List<MapRole> allMapRole1 = allMapRole.stream().filter(e->e.getRoleIndex()==1).collect(Collectors.toList());
//        List<MapRole> allMapRole2 = allMapRole.stream().filter(e->e.getRoleIndex()==2).collect(Collectors.toList());
//        handleDiffIndex(allMapRole1, resList, "1");
//        handleDiffIndex(allMapRole2, resList, "2");
//
//        if (resList.size()!=14) {
//            List<Integer> allExistRoomNum = allMapRole.stream().map(MapRole::getMapRoom).distinct().collect(Collectors.toList());
//            for (int i = 1; i<=14; i++) {
//                if (!allExistRoomNum.contains(i)) {
//                    String roomName = MapInfo.mapRoomNum.get(Integer.toString(i));
//                    RoomDetailVO res = new RoomDetailVO();
//                    res.setRoomName(roomName);
//                    res.setGameClue("");
//                    res.setGameTool("");
//                    resList.add(res);
//                }
//            }
//        }
//
//        resList = resList.stream().sorted(Comparator.comparing(RoomDetailVO::getRoomName)).collect(Collectors.toList());
        return ApiResponse.ok(resList);
    }

    private void handleCaptainRoute(List<List<String>> resList){
        List<String> allRoomList = new ArrayList<>();
        for (int i=1; i<=14; i++) {
            allRoomList.add(MapInfo.mapRoomNum.get(Integer.toString(i)));
        }
        resList.add(allRoomList);
        for (int time=0; time<=60; time=time+5) {
            List<String> timeMapRoomList = new ArrayList<>();
            for (int mapRoomNum=1; mapRoomNum<=14; mapRoomNum++) {
                timeMapRoomList.add("");
            }
            resList.add(timeMapRoomList);
        }

        for (Map.Entry<Integer, List<Integer>> entry : MapInfo.captainRoute.entrySet()) {
            List<String> timeMapRoomList = resList.get(entry.getKey()+1);
            for (Integer mapRoomNum : entry.getValue()) {
                timeMapRoomList.set(mapRoomNum-1, "船长\r\n");
            }
        }
    }

    private void handleRoleRoute(List<MapRole> allMapRole, List<List<String>> resList){
        for (MapRole mapRole : allMapRole) {
            List<String> timeMapRoomList = resList.get(mapRole.getArrivedTime()/5+1);
            int index = mapRole.getMapRoom()-1;
            timeMapRoomList.set(index, timeMapRoomList.get(index)+MapInfo.roleInfo.get(mapRole.getRoleId().toString())+"\r\n");
        }
    }

    private void handleGameTool(List<MapRole> allMapRole, List<List<String>> resList){
        for (Map.Entry<String, String> entry : MapInfo.mapRoomTool.entrySet()) {
            String toolWholeName = entry.getKey();
            String toolRoomStr = toolWholeName.substring(11, toolWholeName.indexOf("_"));
            String toolIndexStr = toolWholeName.substring(toolWholeName.indexOf("_")+1, toolWholeName.length());
            int toolRoomNum = Integer.parseInt(toolRoomStr);
            int toolIndexNum = Integer.parseInt(toolIndexStr);
            List<MapRole> toolRoomRoleList = allMapRole.stream()
                    .filter(e->e.getMapRoom()==toolRoomNum && e.getRoleIndex()==toolIndexNum).sorted(Comparator.comparing(MapRole::getArrivedTime)).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(toolRoomRoleList)) {
                List<Integer> arrivedTimeSortedList =
                        toolRoomRoleList.stream().map(MapRole::getArrivedTime).sorted().collect(Collectors.toList());
                int toolRoleNo = Utils.getToolRoleNo(arrivedTimeSortedList);
                if (toolRoleNo!=0) {
                    MapRole toolRole = toolRoomRoleList.get(toolRoleNo-1);
                    List<String> timeMapRoomList = resList.get(toolRole.getArrivedTime()/5+1);
                    int index = toolRole.getMapRoom()-1;
                    timeMapRoomList.set(index, timeMapRoomList.get(index)+MapInfo.roleInfo.get(toolRole.getRoleId().toString())+"获得了"+entry.getValue());
                }
            }
        }
    }

//    private void handleDiffIndex(List<MapRole> allMapRole, List<RoomDetailVO> resList, String roleIndex){
//        Map<Integer,List<MapRole>> allRoleMap = allMapRole.stream().collect(Collectors.groupingBy(MapRole::getMapRoom));
//        for (Map.Entry<Integer, List<MapRole>> entry : allRoleMap.entrySet()) {
//            RoomDetailVO res = new RoomDetailVO();
//            Integer mapRoomNum = entry.getKey();
//            String mapRoomName = MapInfo.mapRoomNum.get(mapRoomNum.toString());
//            res.setRoomName(mapRoomName);
//
//            List<MapRole> roomRoleList =
//                    entry.getValue().stream().sorted(Comparator.comparing(MapRole::getArrivedTime)).collect(Collectors.toList());
//            List<Integer> arrivedTimeSortedList = roomRoleList.stream().map(MapRole::getArrivedTime).collect(Collectors.toList());
//            int toolRoleNo = Utils.getToolRoleNo(arrivedTimeSortedList);
//            if (toolRoleNo==0) {
//                res.setGameTool("");
//            } else {
//                MapRole toolMapRole = roomRoleList.get(toolRoleNo-1);
//                String toolRoleName = MapInfo.roleInfo.get(toolMapRole.getRoleId().toString());
//                String toolName = MapInfo.mapRoomTool.get("mapRoomClue"+mapRoomNum+"_"+roleIndex);
//                if (StringUtils.isEmpty(toolName)) {
//                    res.setGameTool("");
//                } else {
//                    res.setGameTool(toolRoleName+"获得了\n"+toolName);
//                }
//            }
//
//            StringBuilder gameClueSb = new StringBuilder();
//            for (MapRole roomRole : roomRoleList) {
//                gameClueSb.append(Utils.getExploreTimeStr(roomRole.getArrivedTime()))
//                        .append(" ").append(MapInfo.roleInfo.get(roomRole.getRoleId().toString())).append("\n");
//            }
//            res.setGameClue(gameClueSb.toString());
//            resList.add(res);
//        }
//    }
}
