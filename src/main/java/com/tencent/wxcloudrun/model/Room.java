package com.tencent.wxcloudrun.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Room {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String validNum;

    private String roomNum;

    private Date createdTime;
}
