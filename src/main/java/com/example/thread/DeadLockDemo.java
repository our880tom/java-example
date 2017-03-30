package com.example.thread;

//jstack的信息如下：
//"Thread-1":
//at com.example.thread.DeadLockDemo.run(DeadLockDemo.java:32)
//- waiting to lock <0x00000007956205d0> (a java.lang.Object)
//- locked <0x00000007956205e0> (a java.lang.Object)
//at java.lang.Thread.run(Thread.java:745)
//"Thread-0":
//at com.example.thread.DeadLockDemo.run(DeadLockDemo.java:20)
//- waiting to lock <0x00000007956205e0> (a java.lang.Object)
//- locked <0x00000007956205d0> (a java.lang.Object)
//at java.lang.Thread.run(Thread.java:745)
public class DeadLockDemo implements Runnable{
	private static Object  obj1 = new Object();
	
	private static Object obj2 = new Object();
	
	public int flag = 1;

	public void run() {
		System.out.println("flag" + flag);
		if(flag == 1){
			synchronized (obj1) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (obj2) {
					System.out.println("1");
				}
			}
		}
		if(flag == 0){
			synchronized (obj2) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (obj1) {
					System.out.println("0");
				}
			}
		}
		
	}
	public static void main(String[] args) {
		DeadLockDemo deadLockDemo1 = new DeadLockDemo();
		DeadLockDemo deadLockDemo2 = new DeadLockDemo();
		deadLockDemo1.flag = 1;
		deadLockDemo2.flag = 0;
		new Thread(deadLockDemo1).start();
		new Thread(deadLockDemo2).start();
		
	}
	

}
