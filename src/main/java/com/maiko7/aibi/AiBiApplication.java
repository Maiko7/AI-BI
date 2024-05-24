package com.maiko7.aibi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.maiko7.aibi.mapper")
public class AiBiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiBiApplication.class, args);
    }

}
