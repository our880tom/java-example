package com.example.jvm;

public class StackOverFlowDemo {
	public static void main(String[] args) {
		method();
	}

	public static void method() {
		for (;;) {
			method();
		}

	}

	// 没有设置jvm参数
}
