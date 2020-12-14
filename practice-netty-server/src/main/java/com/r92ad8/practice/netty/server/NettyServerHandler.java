package com.r92ad8.practice.netty.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NettyServerHandler implements ChannelInboundHandler {

    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        log.info("channel registered......");
    }

    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        log.info("channel unregistered......");
    }

    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("channel active......");
    }

    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("channel inactive......");
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("channel read......");
    }

    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        log.info("channel read complete......");
    }

    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        log.info("user event triggered......");
    }

    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        log.info("channel writability changed......");
    }
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("exception caught......");
    }

    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        log.info("handler added......");
    }

    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        log.info("handler removed......");
    }
}
