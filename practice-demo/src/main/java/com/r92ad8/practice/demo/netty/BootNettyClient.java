package com.r92ad8.practice.demo.netty;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BootNettyClient {

    public void connect(String host, int port) {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap()
                .group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new BootNettyChannelInitializer<SocketChannel>());
        ChannelFuture channelFuture = bootstrap.connect(host, port);
        log.info("netty client start success! host:{},port", host, port);
        try {
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException interruptedException) {
            log.error("closeFuture InterruptedException", interruptedException);
        } finally {
            /**
             * 退出，释放资源
             */
            group.shutdownGracefully();
        }
    }
}
