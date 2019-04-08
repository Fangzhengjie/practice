package com.r92ad8.dubbo.user.api.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.r92ad8")
public class UserApiDubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApiDubboConsumerApplication.class, args);
    }

}
