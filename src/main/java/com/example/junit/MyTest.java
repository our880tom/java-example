package com.example.junit;

import java.util.LinkedHashMap;

import org.junit.Test;

import junit.framework.TestCase;

public class MyTest extends TestCase{
   @Test
   public void test(){
	   System.out.println("this is test");
	   LinkedHashMap<Integer,Integer> linkHashMap = new LinkedHashMap<Integer, Integer>();
   }
}
