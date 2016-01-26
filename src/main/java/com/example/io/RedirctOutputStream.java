package com.example.io;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class RedirctOutputStream {
	public static void main(String[] args) throws FileNotFoundException {
       PrintStream out = System.out;
       PrintStream log = new PrintStream("/Users/zhaoliang/a.txt");
       System.setOut(log);
       System.out.println("这是一个日志文件");
       System.setOut(out);
       System.out.println("程序结束请查看日志文件");
       
       
	}
}
