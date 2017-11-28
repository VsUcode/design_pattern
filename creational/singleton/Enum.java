package com.vsu.creational.singleton;

/**
 * Created by vsu on 2017/11/28.
 */


/**
 * 枚举
 * 使用枚举除了线程安全和防止反射调用构造器之外，还提供了自动序列化机制，防止反序列化的时候创建新的对象。
 */

enum Singleton1{
    INSTANCE;

    public void show(){
        System.out.println("枚举");
    }
}
public class Enum {
    public static void main(String[] args) {
        Singleton1 singleton = Singleton1.INSTANCE;
        singleton.show();
    }
}
