package com.r92ad8.practice.demo.netty.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NettyServerHandler implements ChannelInboundHandler {

    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        log.info("channelRegistered,ctx:{}", ctx);
    }

    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        log.info("channelUnregistered,ctx:{}", ctx);
    }

    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("channelActive,ctx:{}", ctx);
    }

    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("channelInactive,ctx:{}", ctx);
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("channelRead,ctx:{},msg:{}", ctx, msg);
    }

    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        log.info("channelReadComplete,ctx:{}", ctx);
    }

    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        log.info("userEventTriggered,ctx:{},evt:{}", ctx, evt);
    }

    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        log.info("channelWritabilityChanged,ctx:{}", ctx);
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("exceptionCaught,ctx:{},cause:{}", ctx, cause);
    }

    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        log.info("handlerAdded,ctx:{}", ctx);
    }

    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        log.info("handlerRemoved,ctx:{}", ctx);
    }
}
