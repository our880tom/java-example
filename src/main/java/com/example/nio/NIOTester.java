package com.example.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * zhaoliang1
 * Created by 2016/11/3
 */
public class NIOTester {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while(true){
            try {
                selector.select();
            }catch (IOException e){
                e.printStackTrace();
                break;
            }

            selector.select();
        }

        Set<SelectionKey> readKeys = selector.selectedKeys();
        for (Iterator<SelectionKey> it = readKeys.iterator(); it.hasNext();){
            SelectionKey key = it.next();
            it.remove();
            try{
                if (key.isAcceptable()){
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel client = server.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_WRITE);

                }else if(key.isWritable()){
                    SocketChannel client = (SocketChannel)key.channel();
                    ByteBuffer buffer ;
                    String str = "Hello";
                    buffer = ByteBuffer.wrap(str.getBytes());
                    client.write(buffer);
                    key.cancel();
                }

            }catch (IOException e){
                key.cancel();
                try{
                    key.channel().close();
                }catch (IOException el){
                    el.printStackTrace();
                }
            }
        }
    }

}
