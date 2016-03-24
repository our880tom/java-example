/**
 * @File name : Service.java
 * @Description : 
 * @Creator : zhaoliang1
 * @CreateTime : 2016年3月24日 上午11:07:11
 * @Version : 1.0
 * @Update records:
 *      1.1 2016年3月24日 by zhaoliang1: 
 *      1.0 2016年3月24日 by zhaoliang1: Created 
 * All rights served : SINA Corporation
 */
package com.example.thrift.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;

import com.example.thrift.HelloWorldService;


public class ServiceDemo {
    public static final int SERVER_PORT = 8090;
    public void startServer(){
        try{
            System.out.println("HelloWorld TSimpleServer start ..");
            TProcessor tProcessor = new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldServiceImpl());
            TServerSocket serverTransport = new TServerSocket(SERVER_PORT);
            TServer.Args tArgs = new TServer.Args(serverTransport);
            tArgs.processor(tProcessor);
            tArgs.protocolFactory(new TBinaryProtocol.Factory());
            TServer tServer = new TSimpleServer(tArgs);
            tServer.serve();
            
        }catch(Exception e){
            System.out.println("Server start error");
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) {
        ServiceDemo serviceDemo = new ServiceDemo();
        serviceDemo.startServer();
    }
}
