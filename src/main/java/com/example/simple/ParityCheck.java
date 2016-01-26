package com.example.simple;

import java.util.Scanner;

public class ParityCheck {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入数字");
		long number = scanner.nextLong();
		String check = (number % 2 == 0)?"这个数字是偶数":"这个数字是基数";
		System.out.println(check);
		scanner.close();

	}

}
