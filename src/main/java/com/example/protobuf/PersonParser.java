/**
 * @File name : PersonParser.java
 * @Description : 
 * @Creator : zhaoliang1
 * @CreateTime : 2016年3月21日 下午5:13:06
 * @Version : 1.0
 * @Update records:
 *      1.1 2016年3月21日 by zhaoliang1: 
 *      1.0 2016年3月21日 by zhaoliang1: Created 
 * All rights served : SINA Corporation
 */
package com.example.protobuf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;


public class PersonParser {
    public static byte[] serialize() throws IOException{
        PersonMsg.Person.Builder builder = PersonMsg.Person.newBuilder();
        builder.setId(1);
        builder.setName("叉叉哥");
        builder.setEmail("xxg@163.com");
        builder.addFriends("Friend A");
        builder.addFriends("Friend B");
        PersonMsg.Person xxg = builder.build();
        
        // 将数据写到输出流，如网络输出流，这里就用ByteArrayOutputStream来代替
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        xxg.writeTo(output);
        return output.toByteArray();
    }
    
    public static void deserialize(byte[] byteArray) throws IOException{
        ByteArrayInputStream input = new ByteArrayInputStream(byteArray);
        
        // 反序列化
        PersonMsg.Person xxg2 = PersonMsg.Person.parseFrom(input);
        System.out.println("ID:" + xxg2.getId());
        System.out.println("name:" + xxg2.getName());
        System.out.println("email:" + xxg2.getEmail());
        System.out.println("friend:");
        List<String> friends = xxg2.getFriendsList();
        for(String friend : friends) {
          System.out.println(friend);
        }
    }
    
    public static void main(String[] args) throws IOException {
        deserialize(serialize());
    }
}
