package com.example.jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapOutOfMemoryDemo {

	public static void main(String[] args) throws InterruptedException{
		
		List<Object> list = new ArrayList<Object>();
		int i = 0;
		while(true){
			if(i < 20){
				i ++;
				Thread.sleep(1000);
			}
			list.add(new Object());
		}
		//-Xms128M -Xmx512M -XX:PermSize=64M -XX:MaxPermSize=128M
		//用VisualVM测试，老年代满
	}

}
