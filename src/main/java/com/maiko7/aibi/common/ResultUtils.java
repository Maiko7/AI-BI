package com.maiko7.aibi.common;

/**
 * 返回工具类
 * @author: Maiko7
 * @create: 2024-05-23-20:30
 */
public class ResultUtils {

    /**
     * 成功
     * @param data 比如userController中userLogin返回user，这个data就是user
     * @param <T>  泛型，增强通用性
     * @return
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0, data, "ok");
    }

    /**
     * 失败。失败返回的是ResultUtils.error(ErrorCode.PARAMS_ERROR);就没有泛型一说，都是直接返回错的自定义码
     * @param errorCode
     * @return
     */
    public static BaseResponse error (ErrorCode errorCode) {
        return new BaseResponse<>(errorCode);
    }

    /**
     * 失败      全局异常处理器BusinessException调的，因为他没有ErrorCode
     *
     * @param code
     * @param message
     * @param description
     * @return
     */
    public static BaseResponse error (int code, String message, String description) {
        return new BaseResponse(code, null, message, description);
    }

    /**
     * 失败  全局异常处理器RuntimeException调的，因为他没有code，所以第一个只能是ErrorCode
     *
     * @param errorCode
     * @return
     */
    public static BaseResponse error (ErrorCode errorCode, String message, String description) {
        return new BaseResponse(errorCode.getCode(), null, message, description);
    }

    public static BaseResponse error (ErrorCode errorCode, String description) {
        return new BaseResponse(errorCode.getCode(), errorCode.getMessage(), description);
    }


}
