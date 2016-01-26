package com.example.security;

import java.util.Scanner;

public class Simple {
	public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.println("请输入字符串：");
       String source = scanner.nextLine();
       char[] array = source.toCharArray();
       for(int i = 0; i < array.length; i ++){
    	   array[i] = (char)(array[i]^2000);
       }
       System.out.print("加密或者解密结果：");
       System.out.println(new String(array));
       scanner.close();
	}
}
