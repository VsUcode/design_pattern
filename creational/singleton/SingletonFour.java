package com.vsu.creational.singleton;

/**
 * Created by vsu on 2017/11/28.
 */


/**
 * 静态内部类
 * 它与饿汉模式一样，也是利用了类加载机制，因此不存在多线程并发的问题。不一样的是，它是在内部类里面去创建对象实例。
 * 这样的话，只要应用中不使用内部类，JVM就不会去加载这个单例类，也就不会创建单例对象，从而实现懒汉式的延迟加载。
 * 也就是说这种方式可以同时保证延迟加载和线程安全。
 */
public class SingletonFour {

    private static class Singleton{
        public static SingletonFour singletonFour = new SingletonFour();
    }

    private SingletonFour(){}

    public static SingletonFour newInstance(){
        return Singleton.singletonFour;
    }
}
