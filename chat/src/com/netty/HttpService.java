package com.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public interface HttpService {
    void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest request);
}
