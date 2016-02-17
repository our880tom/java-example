/**
 * @File name : Singleton.java
 * @Description :
 * @Creator : zhaoliang1
 * @CreateTime : 2016年2月17日 下午4:33:24
 * @Version : 1.0
 * @Update records:
 *         1.1 2016年2月17日 by zhaoliang1:
 *         1.0 2016年2月17日 by zhaoliang1: Created
 *         All rights served : SINA Corporation
 */
package com.example.pattern.singleton;

public class Singleton {

    private Singleton() {}

    private static class SingletonHodler {

        private static final Singleton instance = new Singleton();
    }

    public static synchronized Singleton getInstance() {
        return SingletonHodler.instance;
    }
}

class SingletonUnsafe{
    private SingletonUnsafe(){}
    private static SingletonUnsafe instance;
    public static SingletonUnsafe getInstance(){
        if(instance == null){
            instance = new SingletonUnsafe();
        }
        return instance;
    }
    
}
