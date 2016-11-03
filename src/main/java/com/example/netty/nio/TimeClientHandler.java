/**
 * @File name : TimeClientHandler.java
 * @Description : 
 * @Creator : zhaoliang1
 * @CreateTime : 2016年4月7日 下午4:20:14
 * @Version : 1.0
 * @Update records:
 *      1.1 2016年4月7日 by zhaoliang1: 
 *      1.0 2016年4月7日 by zhaoliang1: Created 
 * All rights served : SINA Corporation
 */
package com.example.netty.nio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;


public class TimeClientHandler extends ChannelHandlerAdapter{
    private final ByteBuf firstMessage;
    
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception{
        super.channelActive(ctx);
        ctx.writeAndFlush(firstMessage);
    }
    
    public TimeClientHandler(){
        byte[] req = "QUERY TIME ORDER".getBytes();
        firstMessage = Unpooled.buffer(req.length);
        firstMessage.writeBytes(req);
    }
    
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
        ByteBuf buf = (ByteBuf)msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req,"UTF-8");
        System.out.println("Now is :" + body);
    }
    
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("xxxxxxxxx");
        ctx.close();
    }
    
    
}
