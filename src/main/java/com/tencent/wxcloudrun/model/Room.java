package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.util.Date;

@Data
public class Room {

    private Integer id;

    private String validNum;

    private String roomNum;

    private Date createdTime;
}
