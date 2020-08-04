package com.github.dingey.sample;

import com.github.dingey.auth.EnableAuth;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.github.dingey.auth.mapper")
@EnableAuth
@SpringBootApplication
public class SampleMybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleMybatisApplication.class, args);
    }
}
