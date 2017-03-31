package com.example.reflect.factory;

public class Factory {
	public static Product getProduct(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return (Product)Class.forName(className).newInstance();
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Product a = Factory.getProduct("com.example.reflect.factory.ProductA");
		a.show();
		Product b = Factory.getProduct("com.example.reflect.factory.ProductB");
		b.show();
	}
}
