package com.maiko7.aibi;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.maiko7.aibi.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class AiBiApplicationTests {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 测一下数据库查询是否有问题
     */
    @Test
    void testSQL() {
        User user = new User();
        user.setUserPassword("12345678");
        user.setUserAccount("maiko7");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", user.getUserAccount());
    }

    /**
     * 测一下Redis序列化是否设置成功
     */
    @Test
    void testRedis() {
        // 写入一条String数据
        redisTemplate.opsForValue().set("name", "要发财的小胡");
        // 读取String数据
        System.out.println(redisTemplate.opsForValue().get("name"));
    }

}
