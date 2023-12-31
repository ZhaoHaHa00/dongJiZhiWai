package com.tencent.wxcloudrun.config;

import lombok.Data;

import java.util.HashMap;

@Data
public final class ApiResponse {

  private Integer code;
  private String errorMsg;
  private Object data;

  private ApiResponse(int code, String errorMsg, Object data) {
    this.code = code;
    this.errorMsg = errorMsg;
    this.data = data;
  }
  
  public static ApiResponse ok() {
    return new ApiResponse(0, "", new HashMap<>());
  }

  public static ApiResponse ok(String message) {
    return new ApiResponse(0, message, new HashMap<>());
  }

  public static ApiResponse ok(Object data) {
    return new ApiResponse(0, "", data);
  }

  public static ApiResponse ok(String message, Object data) {
    return new ApiResponse(0, message, data);
  }

  public static ApiResponse error(String errorMsg) {
    return new ApiResponse(88, errorMsg, new HashMap<>());
  }
}
