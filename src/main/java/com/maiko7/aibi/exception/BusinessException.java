package com.maiko7.aibi.exception;

import com.maiko7.aibi.common.ErrorCode;

/**
 * 自定义异常类
 * @author: Maiko7
 * @create: 2024-05-23-11:37
 */
public class BusinessException extends RuntimeException{

    /**
     * ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
     * 你知道它这里为什么没有message吗？因为异常中本来就是message
     * 这里是相当于一个RuntimeException的增强自定义异常类，所以它只需要管增加的，
     * 这里相对于RuntimeException，增加了code和description
     */

    /**
     * 异常码
     */
    private final int code;

    /**
     * 描述
     */
    private final String description;

    public BusinessException(String message, int code, String description) {
        // 你平时抛出异常的时候，是不是就是字符串。比如Throw new RuntimeException("空指针异常");
        super(message);
        this.code = code;
        this.description = description;
    }

    /**
     * 类似这种  throw new BusinessException(ErrorCode.PARAMS_ERROR);
     * @param errorCode
     */
    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.description = errorCode.getDescription();
    }

    public BusinessException(ErrorCode errorCode, String description) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
