package com.example.thread.pc3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by 那你很棒棒哦 on 2017/6/6.
 */
public class PublicBoxQueue {
    public static void main(String[] args){
        BlockingQueue publicBoxQueue = new LinkedBlockingDeque(5);
        Thread pro = new Thread(new ProducerQueue(publicBoxQueue));
        Thread con = new Thread(new ConsumerQueue(publicBoxQueue));
        pro.start();
        con.start();
    }
}
