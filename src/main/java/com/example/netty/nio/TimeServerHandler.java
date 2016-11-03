/**
 * @File name : TimeServerHandler.java
 * @Description :
 * @Creator : zhaoliang1
 * @CreateTime : 2016年4月7日 下午3:09:13
 * @Version : 1.0
 * @Update records:
 *         1.1 2016年4月7日 by zhaoliang1:
 *         1.0 2016年4月7日 by zhaoliang1: Created
 *         All rights served : SINA Corporation
 */
package com.example.netty.nio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class TimeServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "UTF-8");
        System.out.println("The time Server receive prder :" + body);
        String currenctTime = "QUERY TIME ORDER".equals(body) ? new java.util.Date(
                System.currentTimeMillis()).toString() : "BAD ORDER";
        ByteBuf resp = Unpooled.copiedBuffer(currenctTime.getBytes());
        ctx.write(resp);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
