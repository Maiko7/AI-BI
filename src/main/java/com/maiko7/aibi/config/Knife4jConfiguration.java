package com.maiko7.aibi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 
@Configuration
@EnableSwagger2
/**
 * @Profile({"dev", "test"}) 是Spring框架中用来标识特定bean在哪些环境下应该被激活的注解。
 * 在这个例子中，@Profile({"dev", "test"}) 表示被注解的bean将在"dev"环境和"test"环境下被激活。
 * 这意味着，只有当应用程序运行在"dev"或"test"环境时，这个bean才会被Spring容器加载和管理。
 */
@Profile({"dev", "test"})
public class Knife4jConfiguration {
 
//    @Bean(value = "defaultApi2")
    @Bean
    public Docket defaultApi2() {
        String groupName="3.0.3版本";
        Docket docket=new Docket(DocumentationType.OAS_30)
                .apiInfo(new ApiInfoBuilder()
                        .title("这是对接ChatGPT的智能BI项目的knife4j API ")
                        .description("# 这里记录服务端所有的接口的入参，出参等等信息")
                        .termsOfServiceUrl("https://github.com/Maiko7")
                        .contact(new Contact("不靠谱的小胡","http://127.0.0.1","945073480@qq.com"))
                        .version("3.0")
                        .build())
                //分组名称
                .groupName(groupName)
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.maiko7.aibi.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
 
}