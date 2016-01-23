package com.example.simple;

import java.util.Scanner;

public class ConsoleInput {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入一行文字");
		String consoleLine = scan.nextLine();
		System.out.println("控制台输入的是：" + consoleLine);
		scan.close();
	}
}
