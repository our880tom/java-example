package com.example.thread.pc1;

/**
 * Created by 那你很棒棒哦 on 2017/6/2.
 */
public class ProducerConsumerTest {
    public static void main(String[] args){
        Container container = new Container();
        Producer producer = new Producer(container);
        Consumer consumer = new Consumer(container);
        new Thread(producer).start();
        new Thread(consumer).start();
    }

}

class Goods{
    int id;
    public Goods(int id){
        this.id  = id;
    }

    @Override
    public String toString(){
        return "商品" + this.id;
    }
}

class Container{
    private int index = 0;
    Goods[] goods = new Goods[6];

    public synchronized void push(Goods good){
        while(index == goods.length){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        goods[index] = good;
        index ++;
        notifyAll();

    }

    public synchronized Goods pop(){
        while(index == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        index --;
        notifyAll();
        return goods[index];
    }
}

class Producer implements Runnable{
    Container con = new Container();
    public Producer(Container con){
        this.con = con;
    }
    public void run() {
        for (int i = 0; i < 20; i ++){
            Goods good = new Goods(i);
            con.push(good);
            System.out.println("生产了：" + good);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{
    Container con = new Container();
    public Consumer(Container con){
        this.con = con;
    }
    public void run() {
        for (int i = 0; i < 20; i ++){
            Goods good = con.pop();
            System.out.println("消费了：" + good);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
