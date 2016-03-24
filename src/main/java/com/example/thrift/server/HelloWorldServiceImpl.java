/**
 * @File name : HelloWorldServiceImpl.java
 * @Description : 
 * @Creator : zhaoliang1
 * @CreateTime : 2016年3月24日 上午11:32:15
 * @Version : 1.0
 * @Update records:
 *      1.1 2016年3月24日 by zhaoliang1: 
 *      1.0 2016年3月24日 by zhaoliang1: Created 
 * All rights served : SINA Corporation
 */
package com.example.thrift.server;
import org.apache.thrift.TException;

import com.example.thrift.*;

public class HelloWorldServiceImpl implements HelloWorldService.Iface{

    public String sayHello(String username) throws TException {
        
        return "Hi," + username + " welcome to China!";
    }
}
