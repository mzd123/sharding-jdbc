package com.tuesdayma.mysharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(value = "com.tuesdayma.mysharding.dao")
public class MyshardingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyshardingApplication.class, args);
    }

}
