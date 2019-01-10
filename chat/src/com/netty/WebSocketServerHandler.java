package com.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

public class WebSocketServerHandler extends SimpleChannelInboundHandler<Object> {

    private WebSocketService webSocketService;

    private HttpService httpService;

    public WebSocketServerHandler(WebSocketService webSocketService, HttpService httpService) {
        super();
        this.webSocketService = webSocketService;
        this.httpService = httpService;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        if (o instanceof FullHttpRequest) {
            httpService.handleHttpRequest(channelHandlerContext, (FullHttpRequest)o);
        } else if (o instanceof WebSocketFrame) {
            webSocketService.handleFrame(channelHandlerContext, (WebSocketFrame) o);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception{
        channelHandlerContext.flush();
    }
}
