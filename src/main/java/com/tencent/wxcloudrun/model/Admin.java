package com.tencent.wxcloudrun.model;

import lombok.Data;

@Data
public class Admin {

    private Integer id;

    private String username;

    private String password;

    private Integer type;

    private String storeName;

    private String city;

    private String validNum;
}
