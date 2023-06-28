package com.tencent.wxcloudrun.common;

import lombok.Data;

import java.util.List;

@Data
public class ServiceResponse<T> {

    private Integer code;

    private String message;

    private List<T> dataList;

    public ServiceResponse() {
    }

    public ServiceResponse(Integer code, String message, List<T> dataList) {
        this.code = code;
        this.message = message;
        this.dataList = dataList;
    }
}