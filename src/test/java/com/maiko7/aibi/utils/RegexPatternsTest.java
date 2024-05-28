package com.maiko7.aibi.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 通用正则测试类
 * @author: Maiko7
 * @create: 2024-05-24-9:13
 */
@SpringBootTest
class RegexPatternsTest {

    @Test
    void testRegexPhone() {
        String phone = "18970371855";
        /**
         * Pattern.compile()方法用于将一个正则表达式的字符串编译成一个Pattern对象。
         * pattern.matcher()方法用于创建一个Matcher对象，该对象用来对输入的字符串执行匹配操作。
         * match.matches()方法检查整个输入字符串是否完全匹配正则表达式。
         */
        Matcher matcher = Pattern.compile(RegexPatterns.PHONE_REGEX).matcher(phone);
        if (matcher.matches()) {
            System.out.println("电话格式正确");
        } else {
            System.out.println("电话号码格式不正确");
        }
    }

    @Test
    void testRegexEmail() {
        String email = "945073480@qq.com";
        Matcher matcher = Pattern.compile(RegexPatterns.EMAIL_REGEX).matcher(email);
        if (matcher.matches()) {
            System.out.println("邮箱正则正确");
        } else {
            System.out.println("邮箱正则不正确");
        }
    }

    @Test
    void testRegexPassword() {
//        String password = "123456";
        String password = "123";
        Matcher matcher = Pattern.compile(RegexPatterns.PASSWORD_REGEX).matcher(password);
        if (matcher.matches()) {
            System.out.println("密码正则正确");
        } else {
            System.out.println("密码正则不正确");
        }
    }

    @Test
    void testRegexVerifyCode() {
//        String verifyCode = "123456";
        String verifyCode = "abc123";
        Matcher matcher = Pattern.compile(RegexPatterns.VERIFY_CODE_REGEX).matcher(verifyCode);
        if (matcher.matches()) {
            System.out.println("验证码正则正确");
        } else {
            System.out.println("验证码正则不正确");
        }
    }

    @Test
    void testRegexAccount() {
        String account = "maiko7";
//        String account = "maiko7-";
        Matcher matcher = Pattern.compile(RegexPatterns.ACCOUNT_REGEX).matcher(account);
        if (!matcher.matches()) {
            System.out.println("账号正则正确");
        } else {
            System.out.println("账号正则不正确");
        }
    }
}