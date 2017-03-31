package com.example.reflect;

public class ClassDemo {
	public static void main(String[] args) throws Exception {
		Class<?> class1 = null;
		Class<?> class2 = null;
		Class<?> class3 = null;
		class1 = Class.forName("com.example.reflect.ClassDemo");
		class2 = new ClassDemo().getClass();
		class3 = ClassDemo.class;
		
		System.out.println("类名称 " + class1.getName());
		System.out.println("类名称 " + class2.getName());
		System.out.println("类名称 " + class3.getName());
	}
}
