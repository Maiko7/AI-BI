package com.maiko7.aibi.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求实体类
 * @author: Maiko7
 * @create: 2024-05-23-10:53
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = -7160404799984006627L;

    /**
     * 登陆账号
     */
    private String userAccount;

    /**
     * 密码
     */
    private String userPassword;

}
