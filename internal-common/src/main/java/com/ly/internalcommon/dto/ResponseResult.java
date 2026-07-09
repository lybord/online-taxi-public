package com.ly.internalcommon.dto;

import com.ly.internalcommon.constant.CommonStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 统一响应结果封装，包含状态码、提示消息和业务数据。
 */
@Data
@Accessors(chain = true)
public class ResponseResult<T> {

    /** 业务状态码 */
    private int code;

    /** 响应提示消息 */
    private String message;

    /** 响应业务数据 */
    private T data;

    /** 构建成功响应 */
    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<T>().setCode(CommonStatusEnum.SUCCESS.getCode()).setMessage(CommonStatusEnum.SUCCESS.getValue()).setData(data);
    }

    /** 构建失败响应 */
    public static <T> ResponseResult<T> fail(int code, String message) {
        return new ResponseResult<T>().setCode(code).setMessage(message);
    }

    /** 构建带数据的失败响应 */
    public static  ResponseResult<String> fail(int code, String message, String data) {
        return new ResponseResult<String>().setCode(code).setMessage(message).setData(data);
    }
}
