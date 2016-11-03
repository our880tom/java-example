/**
 * @File name : TimeClient.java
 * @Description : 
 * @Creator : zhaoliang1
 * @CreateTime : 2016年4月7日 下午4:13:05
 * @Version : 1.0
 * @Update records:
 *      1.1 2016年4月7日 by zhaoliang1: 
 *      1.0 2016年4月7日 by zhaoliang1: Created 
 * All rights served : SINA Corporation
 */
package com.example.netty.nio;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;


public class TimeClient {
    public void connect(int port ,String host) throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();
        
        try{
            Bootstrap b = new Bootstrap();
            b.group(group)
             .channel(NioSocketChannel.class)
             .option(ChannelOption.TCP_NODELAY, true)
             .handler(new ChannelInitializer<SocketChannel>(){

                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new TimeClientHandler());
                }
                 
             });
            ChannelFuture f = b.connect(host, port).sync();
            f.channel().closeFuture().sync();
             
            
            
        }finally{
            group.shutdownGracefully();
        }
        
    }

    public static void main(String[] args) throws Exception{
        
        new TimeClient().connect(8080, "127.0.0.1");
    }
}
