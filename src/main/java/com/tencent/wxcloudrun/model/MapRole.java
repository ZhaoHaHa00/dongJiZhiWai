package com.tencent.wxcloudrun.model;

import lombok.Data;

@Data
public class MapRole {

    private Integer id;

    private Integer roomId;

    private Integer roleId;

    private Integer arrivedTime;

    private Integer mapRoom;

    private Integer mapRoomNum;

    private Integer mapRoomClueNum;
}
