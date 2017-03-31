package com.example.reflect;

import java.io.Serializable;

public class ParentClassAndInterfaceDemo implements Serializable{

	private static final long serialVersionUID = 8984836675521344375L;

	public static void main(String[] args) throws Exception{
		Class<?> clazz = Class.forName("com.example.reflect.ParentClassAndInterfaceDemo");
		
		Class<?> parentClass = clazz.getSuperclass();
		System.out.println("clazz的父类为：" + parentClass.getName());
		
		Class<?>[] intes = clazz.getInterfaces();
		for(Class<?> inte : intes){
			System.out.println("接口是：" + inte.getName());
		}
	}
}
