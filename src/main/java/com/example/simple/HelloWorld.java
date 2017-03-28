package com.example.simple;

import java.math.BigDecimal;
import java.util.*;
/**
 * java基本程序hello，world
 * @author zhaoliang
 *
 */
public class HelloWorld {

	public static void main(String[] args) { 
		 Scanner scan  = new Scanner(System.in);
	        double x = scan.nextInt();
	        double y = scan.nextInt();
	        double a = scan.nextInt();
	        double b = scan.nextInt();
	        java.text.DecimalFormat myformat=new java.text.DecimalFormat("0.000000000000");
	        double k = (x * a + y * b) * 1.0 / ( a * a + b * b);
	        double n = (a * k - x) * 1.0 / b;
	        System.out.println(myformat.format(k));
	        System.out.println(myformat.format(n));
	}

}
