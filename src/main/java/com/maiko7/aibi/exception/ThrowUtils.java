package com.maiko7.aibi.exception;

import com.maiko7.aibi.common.ErrorCode;

/**
 * 抛异常工具类
 * @author: Maiko7
 * @create: 2024-05-24-10:49
 */
public class ThrowUtils {

    /**
     * 条件成立则抛异常
     *
     * 在Java中，可以将子类的实例传递给一个接受其父类类型参数的方法。这是因为Java的多态性允许父类引用指向子类对象。
     * throwIf(condition, new BusinessException(errorCode)) 实际上调用的是第一个
     * 重载方法 throwIf(boolean condition, RuntimeException runtimeException)，
     * 其中传入的 runtimeException 是 new BusinessException(errorCode)。
     * 所以这里的RuntimeException异常全是BusinessException。
     *
     *
     * @param condition
     * @param runtimeException
     */
    public static void throwIf (boolean condition, RuntimeException runtimeException) {
        if (condition) {
            throw runtimeException;
        }
    }

    /**
     * 条件成立则抛异常
     * @param condition
     * @param errorCode
     */
    public static void throwIf(boolean condition, ErrorCode errorCode) {
        throwIf(condition, new BusinessException(errorCode));
    }

    /**
     * 条件成立则抛异常
     * @param condition
     * @param errorCode
     * @param message
     */
    public static void throwIf(boolean condition, ErrorCode errorCode, String message) {
        throwIf(condition, new BusinessException(errorCode, message));
    }
}
