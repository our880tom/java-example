/**
 * @File name : TimeServer.java
 * @Description :
 * @Creator : zhaoliang1
 * @CreateTime : 2016年4月7日 下午2:43:53
 * @Version : 1.0
 * @Update records:
 *         1.1 2016年4月7日 by zhaoliang1:
 *         1.0 2016年4月7日 by zhaoliang1: Created
 *         All rights served : SINA Corporation
 */
package com.example.netty.nio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TimeServer {

    public void bind(int port) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChildChannelHandler());
            ChannelFuture f = b.bind(port).sync();
            f.channel().closeFuture().sync();
        }
        finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
    
    private class ChildChannelHandler extends ChannelInitializer<SocketChannel>{

        @Override
        protected void initChannel(SocketChannel arg0) throws Exception {
            System.out.println("test");
            arg0.pipeline().addLast(new TimeServerHandler());
        }
        
    }

    public static void main(String[] args) throws Exception {
        int port =8080;
        new TimeServer().bind(port);
    }
}
