package com.r92ad8.practice.demo.netty;

import com.r92ad8.practice.demo.netty.server.NettyServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.net.InetSocketAddress;

@Slf4j
@SpringBootApplication
public class NettyServerApplication implements CommandLineRunner {

    @Autowired
    NettyServer nettyServer;

    public static void main(String[] args) {
        new SpringApplicationBuilder(NettyServerApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }


    @Override
    public void run(String... args) throws Exception {
        this.nettyServer.start(new InetSocketAddress(8090));
    }
}
