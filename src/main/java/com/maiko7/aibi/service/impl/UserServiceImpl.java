package com.maiko7.aibi.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maiko7.aibi.common.ErrorCode;
import com.maiko7.aibi.constant.UserConstant;
import com.maiko7.aibi.exception.BusinessException;
import com.maiko7.aibi.exception.ThrowUtils;
import com.maiko7.aibi.mapper.UserMapper;
import com.maiko7.aibi.model.entity.User;
import com.maiko7.aibi.model.vo.uservo.LoginUserVO;
import com.maiko7.aibi.service.UserService;
import com.maiko7.aibi.utils.RegexUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.maiko7.aibi.constant.UserConstant.SALT;

/**
* @author Maiko7
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2024-05-23 08:14:51
*/
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword) {
        // 1. 校验
        ThrowUtils.throwIf(StrUtil.isBlank(userAccount), ErrorCode.PARAM_ERROR, "登陆账号为空");
        ThrowUtils.throwIf(StrUtil.isBlank(userPassword), ErrorCode.PARAM_ERROR, "登陆密码为空");
        ThrowUtils.throwIf(StrUtil.isBlank(checkPassword), ErrorCode.PARAM_ERROR, "确认密码为空");
        ThrowUtils.throwIf(userAccount.length() < 4, ErrorCode.PARAM_ERROR, "用户账号过短");
        ThrowUtils.throwIf(userAccount.length() > 32, ErrorCode.PARAM_ERROR, "用户账号过长");
        ThrowUtils.throwIf(RegexUtils.isAccountInvalid(userAccount), ErrorCode.PARAM_ERROR, "账号包含特殊字符");
        ThrowUtils.throwIf(userPassword.length() < 4, ErrorCode.PARAM_ERROR, "用户密码过短");
        ThrowUtils.throwIf(userPassword.length() > 32, ErrorCode.PARAM_ERROR, "用户密码过长");
        ThrowUtils.throwIf(RegexUtils.isPasswordInvalid(userPassword), ErrorCode.PARAM_ERROR, "用户密码包含特殊字符");
        // 1.1 校验密码是否相同
        ThrowUtils.throwIf(!userPassword.equals(checkPassword), ErrorCode.PARAM_ERROR, "两次输入密码不一致");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", userAccount);
        long count = userMapper.selectCount(queryWrapper);
        ThrowUtils.throwIf(count > 0, ErrorCode.PARAM_ERROR, "账号已存在");
        // 2. 密码加密
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT  + userPassword).getBytes());
        // 3. 插入数据
        User user = new User();
        user.setUserAccount(userAccount);
        user.setUserPassword(encryptPassword);
//        boolean saveResult = userMapper.insert(user);  这个insert返回的是int，就是插入成功返回1这种
        boolean saveResult = this.save(user);
        ThrowUtils.throwIf(!saveResult, ErrorCode.PARAM_ERROR, "注册失败");
        return user.getId();
    }

    @Override
    public LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request) {

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
        // 1. 参数校验(校验用户账号和密码是否合法)
        ThrowUtils.throwIf(StringUtils.isAnyBlank(userAccount, userPassword), ErrorCode.PARAM_ERROR, "请求参数位空");
        ThrowUtils.throwIf(userAccount.length() < 4, ErrorCode.PARAM_ERROR, "用户账号过短");
        ThrowUtils.throwIf(userAccount.length() > 32, ErrorCode.PARAM_ERROR, "用户账号过长");
        ThrowUtils.throwIf(RegexUtils.isAccountInvalid(userAccount), ErrorCode.PARAM_ERROR, "账号包含特殊字符");
        ThrowUtils.throwIf(userPassword.length() < 4, ErrorCode.PARAM_ERROR, "用户密码过短");
        ThrowUtils.throwIf(userPassword.length() > 32, ErrorCode.PARAM_ERROR, "用户密码过长");
        ThrowUtils.throwIf(RegexUtils.isPasswordInvalid(userPassword), ErrorCode.PARAM_ERROR, "用户密码包含特殊字符");

        // 2. 和数据库密码比对，校验密码是否正确
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", userAccount);
        queryWrapper.eq("userPassword", encryptPassword);
//        User user = this.getOne(queryWrapper);
        User user = userMapper.selectOne(queryWrapper);
        // 这里肯定有个校验，因为用户可以通过校验，比如我输入一个maiko6，密码为12345679。不是都符合吗，但是数据库却查不到
        if (user == null) {
            log.info("user login failed, userAccount cannot match userPassword");
            throw new BusinessException(ErrorCode.PARAM_ERROR, "用户不存在或密码错误");
//            ResultUtils.error(ErrorCode.PARAM_ERROR, "用户账号不存在或者密码不匹配");
        }
        request.getSession().setAttribute(UserConstant.USER_LOGIN_STATE + user.getId(), user);
        LoginUserVO loginUserVO = BeanUtil.copyProperties(user, LoginUserVO.class);
        return loginUserVO;
    }

}




