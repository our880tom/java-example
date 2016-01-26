package com.example.simple;

import java.util.Scanner;

public class TwoPower {

	public static void main(String[] args) {
	  Scanner scanner = new Scanner(System.in);
	  System.out.println("请输入一个正数");
	  long number = scanner.nextLong();
	  System.out.println("乘以2的结果是：" + (number << 1));
	  System.out.println("乘以4的结果是：" + (number << 2));
	  System.out.println("乘以8的结果是：" + (number << 3));
	  System.out.println("乘以16的结果是：" + (number << 4));
	  scanner.close();
	}

}
