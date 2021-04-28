package com.r92ad8.practice.demo.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.InetSocketAddress;

@Component
@Slf4j
public class NettyServer {

    public static NettyServer nettyServer;

    private static class SingletonNettyServer {
        static final NettyServer instance = new NettyServer();
    }

    public NettyServer getInstance() {
        return SingletonNettyServer.instance;
    }

    @PostConstruct
    public void init() {
        nettyServer = getInstance();
    }


    public void start(InetSocketAddress socketAddress) {
        //创建一个主线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        //创建一个工作线程组
        EventLoopGroup workGroup = new NioEventLoopGroup(200);

        ServerBootstrap bootstrap = new ServerBootstrap().group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ServerChannelInitializer())
                .localAddress(socketAddress)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true);
        try {
            ChannelFuture channelFuture = bootstrap.bind(socketAddress).sync();
            log.info("Netty服务启动,监听端口:{}", socketAddress.getPort());
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException interruptedException) {
            log.error("InterruptedException Exception", interruptedException);
        } finally {
            //关闭工作线程组
            workGroup.shutdownGracefully();
            //关闭主线程组
            bossGroup.shutdownGracefully();
        }
    }

}
