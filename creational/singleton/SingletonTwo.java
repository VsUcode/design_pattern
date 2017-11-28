package com.vsu.creational.singleton;

/**
 * Created by vsu on 2017/11/28.
 */


/**
 * 懒汉式
 * 懒汉模式中单例是在需要的时候才去创建的，如果单例已经创建，再次调用获取接口将不会重新创建新的对象，而是直接返回之前创建的对象。
 * 如果某个单例使用的次数少，并且创建单例消耗的资源较多，那么就需要实现单例的按需创建，这个时候使用懒汉模式就是一个不错的选择。
 */
public class SingletonTwo {

    private static SingletonTwo singletonTwo = null;

    private SingletonTwo(){}

    /**
     * 线程安全
     */
    public static synchronized SingletonTwo NewInstanceOne(){
        if (singletonTwo == null){
            singletonTwo = new SingletonTwo();
        }
        return singletonTwo;
    }


    /**
     * 线程不安全的
     */
    public static SingletonTwo NewInstanceTwo(){
        if (singletonTwo == null){
            singletonTwo = new SingletonTwo();
        }
        return singletonTwo;
    }

}
