package com.example.generic;

/**
 * Created by 那你很棒棒哦 on 2017/5/31.
 */
public class GenericNotAllowExtends {
    public static void main(String[] args){
        Bean<Number> name = new Bean<Number>(99);
        Bean<Integer> age = new Bean<Integer>(127);
        getData(name);

        //this method getData(Bean<Number> data) in the type GenericNotAllowExtends is
        //not applicable for the arguments (Bean<Integer>)
        //getData(age);
    }

    public static void getData(Bean<Number> data){
        System.out.println("data:" + data.getData());
    }
}
