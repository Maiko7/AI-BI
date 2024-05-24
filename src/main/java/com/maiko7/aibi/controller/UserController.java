package com.maiko7.aibi.controller;

import cn.hutool.core.util.StrUtil;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.maiko7.aibi.common.BaseResponse;
import com.maiko7.aibi.common.ErrorCode;
import com.maiko7.aibi.common.ResultUtils;
import com.maiko7.aibi.exception.BusinessException;
import com.maiko7.aibi.exception.ThrowUtils;
import com.maiko7.aibi.model.dto.user.UserLoginRequest;
import com.maiko7.aibi.model.vo.uservo.LoginUserVO;
import com.maiko7.aibi.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户接口
 * @author: Maiko7
 * @create: 2024-05-23-10:43
 */
@RestController
@RequestMapping("/user")
@Slf4j
@ApiSupport(author = "啥也不会的小胡")
@Api(tags = "用户接口")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    @ApiImplicitParam(name = "UserLoginRequest", value = "用户登录请求实体类", required = true)
    @ApiOperation("用户登录接口")
    public BaseResponse<LoginUserVO> userLogin(@RequestBody UserLoginRequest userLoginRequest) {
        // 其实你在上面设置了required = true，起码在swagger层面是必须要输入的。但是在前端就显示不出来了。
        if (userLoginRequest == null) {
            //throw new BusinessException(ErrorCode.PARAM_ERROR);
            // 这里就是用到了详细描述的description
            throw new BusinessException(ErrorCode.PARAM_ERROR, "用户登录请求参数为空");
        }
        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();
        // 你用下面这个统一判断的话你就不好写提示语，你写用户登录的账号或者密码为空吗？要一个一个给提示，用户体验好
//        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
//            throw new BusinessException(ErrorCode.PARAM_ERROR, "用户登录账号为空");
//        }

        /**
         * 下面是对if (StrUtil.isBlank(userAccount)) {
         * //            throw new BusinessException(ErrorCode.PARAM_ERROR, "用户登录账号为空");
         * //        }
         * 进行的升级。
         * ThrowUtils.throwIf(StrUtil.isBlank(userAccount), ErrorCode.PARAM_ERROR, "用户登录账号为空");
         */
//        if (StrUtil.isBlank(userAccount)) {
//            throw new BusinessException(ErrorCode.PARAM_ERROR, "用户登录账号为空");
//        }
        ThrowUtils.throwIf(StrUtil.isBlank(userAccount), ErrorCode.PARAM_ERROR, "用户登录账号为空");
//        if (StrUtil.isBlank(userPassword)) {
//            throw new BusinessException(ErrorCode.PARAM_ERROR, "用户登录密码为空");
//        }
        ThrowUtils.throwIf(StrUtil.isBlank(userPassword), ErrorCode.PARAM_ERROR, "用户登录密码为空");
        LoginUserVO loginUserVO = userService.userLogin(userAccount, userPassword);
        return ResultUtils.success(loginUserVO);
    }
}
