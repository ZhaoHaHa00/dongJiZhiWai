package com.tencent.wxcloudrun.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MapRole {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private Long roomId;

    private Integer roleId;

    private Integer arrivedTime;

    private Integer mapRoom;

    private Integer roleIndex;
}
