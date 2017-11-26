package com.vsu.creational.factory_method;

/**工厂方法模式分为三种：普通工厂模式、多个工厂方法模式和静态工厂方法模式
 * Created by vsu on 2017/11/26.
 */



/**
 * 普通工厂模式就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建
 */
class MyFactory1 {

    public MyInterface produce(String type) {
        if ("One".equals(type)) {
            return new MyClassOne();
        } else if ("Two".equals(type)) {
            return new MyClassTwo();
        } else {
            System.out.println("没有要找的类型");
            return null;
        }
    }

}

public class Factory1 {

    public static void main(String[] args){
        MyFactory1 factory = new MyFactory1();
        MyInterface myi = factory.produce("One");
        myi.print();//MyClassOne

    }
}
