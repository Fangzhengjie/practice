package com.r92ad8.practice.multithread;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MultiThreadPracticeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MultiThreadPracticeApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }


    @Override
    public void run(String... args) throws Exception {
    }
}
