package com.atguigu.gmall.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan("com.atguigu.gmall")
@MapperScan(basePackages = "com.atguigu.gmall.order.mapper")
@EnableTransactionManagement
public class GmallOrderServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallOrderServerApplication.class, args);
    }

}
