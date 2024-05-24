package com.maiko7.aibi.utils;

import cn.hutool.core.util.StrUtil;

/**
 * 通用正则匹配工具类
 * @author: Maiko7
 * @create: 2024-05-24-10:19
 */
public class RegexUtils {
    /**
     * 是否是无效手机格式
     * @param phone 要校验的手机号
     * @return
     */
    public static boolean isPhoneInvalid(String phone) {
        return mismath(phone, RegexPatterns.PHONE_REGEX);
    }

    /**
     * 是否是无效邮箱格式
     * @param email 要校验的邮箱
     * @return
     */
    public static boolean isEmailInvalid(String email) {
        return mismath(email, RegexPatterns.EMAIL_REGEX);
    }

    /**
     * 是否是无效验证码格式
     * @param verifyCode 要校验的验证码
     * @return
     */
    public static boolean isVerifyCodeInvalid(String verifyCode) {
        return mismath(verifyCode, RegexPatterns.VERIFY_CODE_REGEX);
    }

    /**
     * 是否是无效账号格式
     * @param account 要校验的账号
     * @return
     */
    public static boolean isAccountInvalid(String account) {
        return mismath(account, RegexPatterns.ACCOUNT_REGEX);
    }

    /**
     * 是否是无效密码格式
     * @param password 要校验的密码
     * @return
     */
    public static boolean isPasswordInvalid(String password) {
        return mismath(password, RegexPatterns.PASSWORD_REGEX);
    }



    /**
     * 他这里要的是不匹配。你可能要问了，为什么要取反多此一举呢？直接匹配不是更好理解吗？
     * 因为你这个是要用于验证的，比如密码不正确。它这个就是为了验证而生的，所以用不匹配更好。
     * @param str
     * @param regex
     * @return
     */
    private static boolean mismath(String str, String regex) {
        if (StrUtil.isBlank(str)) {
            return true;
        }
        /**
         * 这是String的matches()方法，不是正则表达式Matcher的matches()方法
         * matches用于判断 str 是否符合指定的正则表达式 regex。它返回一个布尔值，
         * 如果字符串 str 符合正则表达式 regex，则返回 true，否则返回 false。
         * 他这里是取反，也就是不符合返回false但是取反就是true了
         */
        return !str.matches(regex);
    }
}
