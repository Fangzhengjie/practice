package com.r92ad8.practice.demo.prometheus;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@Slf4j
@SpringBootApplication
public class PrometheusApplication implements CommandLineRunner {

    public static void main(String[] args) {
        new SpringApplicationBuilder(PrometheusApplication.class)
                .run(args);
    }

    @Override
    public void run(String... args) throws Exception {
    }

}
