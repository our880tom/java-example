package com.example.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 那你很棒棒哦 on 2017/5/31.
 */
public class Sample {
    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        list.add("add");

        for (int i = 0; i < list.size(); i ++){
            String name = list.get(i);
            System.out.println("name:" + name);
        }
    }
}
