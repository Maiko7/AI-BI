package com.maiko7.aibi.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: Maiko7
 * @create: 2024-05-28-14:21
 */
@SpringBootTest
class RegexUtilsTest {

    @Test
    void testUserAccount() {
        String userAccount = "maiko7";
        // assertTrue(...) 是一个断言方法,通常用于单元测试中。
        // 它会检查括号内的表达式是否为 true。如果表达式为 false，则断言失败,测试用例也会失败。
        assertTrue(!RegexUtils.isAccountInvalid(userAccount));

        /**
         * Assertions.assertEquals(-1, result);
         * Assertions.assertEquals() 方法接受两个参数:
         * 第一个参数是预期结果: -1
         * 第二个参数是实际结果: result
         * 该方法会比较预期结果和实际结果是否相等。
         * 如果 result 的值不等于 -1，那么断言就会失败,测试用例也会失败。
         */
    }

}