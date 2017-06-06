package com.example.thread.pc2;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 那你很棒棒哦 on 2017/6/5.
 */
public class ProducerConsumerTest {

    Executor pool = Executors.newFixedThreadPool(10);

    private int MAX_SIZE = 3;

    private int ZERO = 0;

    private List<String> storageList = new LinkedList<String>();

    private Lock lock = new ReentrantLock();

    private Condition full = lock.newCondition();

    private Condition empty = lock.newCondition();

    private class Producer implements Runnable{
        private void produce(){
            try {
                lock.lock();
                    System.out.println(Thread.currentThread().getName() + "进入仓库，准备生产");
                    if (storageList.size() == MAX_SIZE) {
                        System.out.println("仓库已满！等待消费者消费");
                         Thread.sleep(1000);
                        full.await();
                    }
                    if (storageList.size() < MAX_SIZE){
                        String name = "产品" + new Random().nextInt();
                        storageList.add(name);
                        System.out.println(Thread.currentThread().getName() + "往仓库中生产了一个" + name);
                    }
                    Thread.sleep(1000);
                    empty.signalAll();
                //}
            }catch(InterruptedException e){
                System.out.println("中断异常");
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

        public void run() {
            while (true){
                produce();
            }
        }
    }

    private class Customer implements Runnable{
        private void consumer(){
                //lock.tryLock()){
            lock.lock();
                System.out.println(Thread.currentThread().getName() + "进入仓库，准备消费！");
                try{
                    if (storageList.size() == ZERO){
                        System.out.println("仓库已空！等待生产者生产");
                        Thread.sleep(1000);
                        empty.await();
                    }
                    if (storageList.size() != ZERO){
                        System.out.println(Thread.currentThread().getName() + "从仓库取得产品：" + storageList.remove(0));
                    }
                    Thread.sleep(1000);
                    full.signalAll();

                }catch (InterruptedException e){
                    System.out.println("中断异常");
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            //}
        }

        public void run() {
            while(true){
                consumer();
            }
        }
    }

    public void start(){
        for (int i = 0; i < 5; i ++){
            pool.execute(new Producer());
            pool.execute(new Customer());
        }
    }

    public static void main(String[] args){
        ProducerConsumerTest test = new ProducerConsumerTest();
        test.start();
    }
}
