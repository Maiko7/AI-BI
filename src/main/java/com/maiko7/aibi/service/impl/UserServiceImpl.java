package com.maiko7.aibi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maiko7.aibi.common.ErrorCode;
import com.maiko7.aibi.exception.ThrowUtils;
import com.maiko7.aibi.mapper.UserMapper;
import com.maiko7.aibi.model.entity.User;
import com.maiko7.aibi.model.vo.uservo.LoginUserVO;
import com.maiko7.aibi.service.UserService;
import com.maiko7.aibi.utils.RegexUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
* @author Maiko7
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2024-05-23 08:14:51
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    @Override
    public LoginUserVO userLogin(String userAccount, String userPassword) {

//        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
//            throw new BusinessException(ErrorCode.PARAM_ERROR, "请求参数位空");
//        }
//        if (userAccount.length() < 4) {
//            throw new BusinessException(ErrorCode.PARAM_ERROR, "用户账号过短");
//        }
//        if (userAccount.length() > 32) {
//            throw new BusinessException(ErrorCode.PARAM_ERROR, "用户账号过长");
//        }
//        if (RegexUtils.isAccountInvalid(userAccount)) {
//            throw new BusinessException(ErrorCode.PARAM_ERROR, "账号包含特殊字符");
//        }
//        if (userPassword.length() < 4) {
//            throw new BusinessException(ErrorCode.PARAM_ERROR, "用户密码过短");
//        }
//        if (userPassword.length() > 32) {
//            throw new BusinessException(ErrorCode.PARAM_ERROR, "用户密码过长");
//        }
//        if (RegexUtils.isPasswordInvalid(userPassword)) {
//            throw new BusinessException(ErrorCode.PARAM_ERROR, "密码包含特殊字符");
//        }

        /**
         * ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
         * 通过对上面多个if进行优化，创建一个抛异常工具类，实现了圈复杂度从7到0的优化。
         */
        ThrowUtils.throwIf(StringUtils.isAnyBlank(userAccount, userPassword), ErrorCode.PARAM_ERROR, "请求参数位空");
        ThrowUtils.throwIf(userAccount.length() < 4, ErrorCode.PARAM_ERROR, "用户账号过短");
        ThrowUtils.throwIf(userAccount.length() > 32, ErrorCode.PARAM_ERROR, "用户账号过长");
        ThrowUtils.throwIf(RegexUtils.isAccountInvalid(userAccount), ErrorCode.PARAM_ERROR, "账号包含特殊字符");
        ThrowUtils.throwIf(userPassword.length() < 4, ErrorCode.PARAM_ERROR, "用户密码过短");
        ThrowUtils.throwIf(userPassword.length() > 32, ErrorCode.PARAM_ERROR, "用户密码过长");
        ThrowUtils.throwIf(RegexUtils.isPasswordInvalid(userPassword), ErrorCode.PARAM_ERROR, "用户密码包含特殊字符");

        // 账号不能包含特殊字符
        return null;
    }
}




