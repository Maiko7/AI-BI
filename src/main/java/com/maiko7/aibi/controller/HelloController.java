package com.maiko7.aibi.controller;

import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口
 * @author: Maiko7
 * @create: 2024-05-22-8:22
 */
@RestController
@RequestMapping("/test")
@ApiSupport(author = "啥也不会的小胡")
@Api(tags = "测试swagger")
public class HelloController {

    @GetMapping("/hello")
    @ApiImplicitParam(name = "name", value = "姓名", required = true)
//    @ApiOperationSupport(author = "啥也不会的小胡11111")
    @ApiOperation("测试接口")
    public String hello(@RequestParam("name") String name){
        return "hello" + name + ",I am Maiko7";
    }
}
