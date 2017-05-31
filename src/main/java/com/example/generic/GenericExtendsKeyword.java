package com.example.generic;

/**
 * Created by 那你很棒棒哦 on 2017/5/31.
 */
public class GenericExtendsKeyword {

    public static void main(String[] args){
        Bean<String> name = new Bean<String>("add");
        Bean<Integer> age = new Bean<Integer>(12);
        Bean<Number> number = new Bean<Number>(13);

        getData(name);
        getData(age);
        getData(number);


        //getUpperNumberData(name);
        getUpperNumberData(age);
        getUpperNumberData(number);
    }

    public static void getData(Bean<?> data){
        System.out.println("data:" + data.getData());
    }

    public static void getUpperNumberData(Bean<? extends Number> data){
        System.out.println("data:" + data.getData());
    }

}
