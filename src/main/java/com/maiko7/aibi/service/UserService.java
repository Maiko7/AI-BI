package com.maiko7.aibi.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.maiko7.aibi.model.entity.User;
import com.maiko7.aibi.model.vo.uservo.LoginUserVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author Maiko7
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2024-05-23 08:14:51
*/
public interface UserService extends IService<User> {

    long userRegister(String userAccount, String userPassword, String checkPassword);

    LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request);

}
