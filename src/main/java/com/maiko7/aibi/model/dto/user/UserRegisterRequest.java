package com.maiko7.aibi.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Maiko7
 * @create: 2024-05-28-20:47
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = -2705662027644680824L;

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 校验密码
     */
    private String checkPassword;
}
