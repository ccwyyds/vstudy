package com.vv;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.vv.mapper")
public class Vstudy2Application {

    public static void main(String[] args) {
        SpringApplication.run(Vstudy2Application.class, args);
    }

}
