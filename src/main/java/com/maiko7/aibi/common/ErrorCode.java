package com.maiko7.aibi.common;

/**
 * 自定义错误码
 * @author: Maiko7
 * @create: 2024-05-23-11:12
 */
public enum ErrorCode {

    SUCCESS(0, "ok", ""),
    /**
     * 请求参数错误后续有：请求参数为空、用户账号过短、用户密码过短等
     */
    PARAM_ERROR(30001, "请求参数错误", ""),
    SYSTEM_ERROR(50000, "系统内部异常", "");

    /**
     *  状态码
     */
    private final int code;

    /**
     * 状态码信息
     */
    private final String message;

    /**
     * 状态码信息（详情）
     * 比如 NO_AUTH(40101, "无权限", "")是无权限，但是无权限你也可以更详细点，什么无权限呢？
     * 比如说管理员无权限。
     */
    private final String description;


    ErrorCode(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getMessage() {
        return message;
    }
}
