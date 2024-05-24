package com.maiko7.aibi.model.vo.uservo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: Maiko7
 * @create: 2024-05-24-11:21
 */
public class LoginUserVO implements Serializable {

    private static final long serialVersionUID = 1966044533599169139L;

    /**
     * 用户id
     */
    private Long id;


    /**
     * 用户昵称
     */
    private String username;


    /**
     * 性别
     */
    private Integer gender;


    /**
     * 头像
     */
    private String avatarUrl;


    /**
     * 用户状态（0-正常, 1-异常）
     */
    private String userStatus;

    /**
     * 用户角色(0-普通用户，1-管理员)
     */
    private Integer userRole;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
