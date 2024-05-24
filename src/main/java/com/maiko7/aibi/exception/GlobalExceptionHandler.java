package com.maiko7.aibi.exception;

import com.maiko7.aibi.common.BaseResponse;
import com.maiko7.aibi.common.ErrorCode;
import com.maiko7.aibi.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器。抛出的BusinessException和RuntimeException都会被它捕获。
 * @author: Maiko7
 * @create: 2024-05-23-20:58
 */



/**
 * @RestControllerAdvice 是一个 Spring Framework 注解，用于集中处理所有
 * @RestController 或 @RequestMapping 注解的控制器中的异常、数据绑定、和全局数据的增强。
 *
 * 比如说你userController就有@RestController，那你这个类中所有的异常就会被GlobalExceptionHandler集中处理。
 * GlobalExceptionHandler就相当于一个拦截器，拦截所有userController的异常。
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * @ExceptionHandler(BusinessException.class) 是 Spring Framework 中用于处理特定异常的注解。
     * 它用于在控制器或控制器增强（例如通过 @ControllerAdvice 或 @RestControllerAdvice 注解）的类中定义一个方法，
     * 当指定的异常（在此例中是 BusinessException）被抛出时，该方法将被调用来处理该异常。
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public BaseResponse<?> businessExceptionHandler(BusinessException e) {
        log.error("businessException: " + e.getMessage(), e);
        /**
         * 为什么它这里能getCode？
         * 因为你BusinessException类中有code和description这两个成员变量，所有它能够通过get获取。
         */
        return ResultUtils.error(e.getCode(), e.getMessage(), e.getDescription());
    }


    @ExceptionHandler(RuntimeException.class)
    public BaseResponse<?> runtimeExceptionHandler(RuntimeException e) {
        log.error("runtimeException: " + e.getMessage(), e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR, e.getMessage(), "");
    }
}
