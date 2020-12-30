package com.r92ad8.practice;

import com.r92ad8.practice.netty.BootNettyClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(PracticeApplication.class, args);
    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        /**
         * 使用异步注解方式启动netty客户端服务
         */
        String host = "127.0.0.1";
        int port = 8090;
        new BootNettyClient().connect(host, port);
    }
}
