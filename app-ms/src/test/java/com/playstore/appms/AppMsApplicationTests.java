package com.playstore.appms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.playstore.appms.feign")
@SpringBootApplication
public class AppMsApplicationTests {
    public static void main(String[] args) {
        SpringApplication.run(AppMsApplication.class, args);
    }
}