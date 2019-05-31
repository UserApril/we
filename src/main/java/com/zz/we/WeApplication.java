package com.zz.we;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zz.we.mapper")
public class WeApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeApplication.class, args);
    }

}
