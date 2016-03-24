/**
 * @File name : Client.java
 * @Description :
 * @Creator : zhaoliang1
 * @CreateTime : 2016年3月24日 上午11:06:59
 * @Version : 1.0
 * @Update records:
 *         1.1 2016年3月24日 by zhaoliang1:
 *         1.0 2016年3月24日 by zhaoliang1: Created
 *         All rights served : SINA Corporation
 */
package com.example.thrift.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import com.example.thrift.HelloWorldService;

public class ClientDemo {

    public static final String SERVER_IP = "localhost";

    public static final int SERVER_PORT = 8090;

    public static final int TIMEOUT = 30000;

    public void startClient(String userName) {
        TTransport transport = null;
        transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
        TProtocol protocal = new TBinaryProtocol(transport);
        HelloWorldService.Client client = new HelloWorldService.Client(protocal);
        try {
            transport.open();
            String result = client.sayHello(userName);
            System.out.println("thrift client result =:" + result);
        }
        catch (TException e) {
            e.printStackTrace();
        }
        finally {
            transport.close();
        }
    }
    
    public static void main(String[] args) {
        ClientDemo client = new ClientDemo();
        client.startClient("zhaoliang");
    }
}
