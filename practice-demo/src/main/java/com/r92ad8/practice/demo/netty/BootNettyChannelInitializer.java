package com.r92ad8.practice.demo.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

public class BootNettyChannelInitializer<SocketChannel> extends ChannelInitializer<Channel> {

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline().addLast("decoder",new StringDecoder(CharsetUtil.UTF_8));
        ch.pipeline().addLast("encoder",new StringEncoder(CharsetUtil.UTF_8));
        ch.pipeline().addLast(new BootNettyChannelInboundHandleAdapter());
    }
}
