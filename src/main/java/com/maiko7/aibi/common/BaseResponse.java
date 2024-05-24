package com.maiko7.aibi.common;

import java.io.Serializable;

/**
 * 通用返回类
 * @author: Maiko7
 * @create: 2024-05-23-20:11
 */
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = -5018221131954611888L;

    /**
     * 状态码
     */
    private int code;

    /**
     * 他这个data就是比如我userController返回的是BaseResponse<User>，它这个data就是User
     * 数据
     */
    private T data;

    /**
     * 消息
     */
    private String message;

    /**
     * 描述
     */
    private String description;

    /**
     * 下面这四个构造函数，分别是四个参数，三个参数，两个参数和一个参数！
     */

    public BaseResponse(int code, T data, String message, String description) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.description = description;
    }

    public BaseResponse(int code, T data, String message) {
        this(code, data, message, "");
    }

    public BaseResponse(int code, T data) {
        this(code, data, "", "");
    }

    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), null, errorCode.getMessage(), errorCode.getDescription());
    }

}
