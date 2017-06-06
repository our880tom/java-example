package com.example.thread.pc3;

import java.util.concurrent.BlockingQueue;

/**
 * Created by 那你很棒棒哦 on 2017/6/6.
 */
public class ProducerQueue implements Runnable{
    private final BlockingQueue proQueue;

    public ProducerQueue(BlockingQueue proQueue) {
        this.proQueue = proQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i ++){
            try{
                System.out.println("生产者的苹果编号：" + i);
                proQueue.put(i);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
