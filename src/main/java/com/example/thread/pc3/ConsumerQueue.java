package com.example.thread.pc3;

import java.util.concurrent.BlockingQueue;

/**
 * Created by 那你很棒棒哦 on 2017/6/6.
 */
public class ConsumerQueue implements Runnable {
    private final BlockingQueue conQueue;

    public ConsumerQueue(BlockingQueue conQueue) {
        this.conQueue = conQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i ++){
            try{
                System.out.println("消费者消费的苹果编号：" + conQueue.take());
                Thread.sleep(3000);

            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
