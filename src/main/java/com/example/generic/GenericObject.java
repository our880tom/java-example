package com.example.generic;

/**
 * Created by 那你很棒棒哦 on 2017/5/31.
 */
public class GenericObject {
    public static void main(String[] args){
        Bean<String> name = new Bean<String>("add");
        Bean<Integer> age = new Bean<Integer>(22);

        System.out.println("name:" + name.getData());
        System.out.println("age:" + age.getData());
    }
}

class Bean<T> {

    private T data;

    public Bean(){

    }

    public Bean(T data){
        this.data = data;
    }

    public T getData(){
        return this.data;
    }
}
