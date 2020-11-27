package com.china;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.china.mapper")
public class StartApplication {
    public static void main(String[] args){
        SpringApplication.run(StartApplication.class, args);
    }
}
