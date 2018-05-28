package com.example.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by zhaoliang1 on 2018/5/28.
 */
public class CallableAndFuture1 {
    public static void main(String[] args){
        Callable<Integer> callable = new Callable<Integer>() {
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        };

        FutureTask<Integer> future = new FutureTask<Integer>(callable);
        new Thread(future).start();

        try {
            Thread.sleep(5000);

            System.out.println(future.get());

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
