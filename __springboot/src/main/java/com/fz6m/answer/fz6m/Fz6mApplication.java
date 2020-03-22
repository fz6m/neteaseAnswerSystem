package com.fz6m.answer.fz6m;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("com.fz6m.answer.fz6m.mapper")
@SpringBootApplication
public class Fz6mApplication {

    public static void main(String[] args) {
        SpringApplication.run(Fz6mApplication.class, args);
    }

}
