package com.vsu.creational.factory_method;

/** 多个工厂方法模式，是对普通工厂方法模式的改进，多个工厂方法模式就是提供多个工厂方法，分别创建对象
 * Created by vsu on 2017/11/26.
 */


class MyFactory2 {

    public MyInterface produceOne() {
        return new MyClassOne();
    }

    public MyInterface produceTwo() {
        return new MyClassTwo();
    }

}


public class Factory2 {
    public static void main(String[] args){
        MyFactory2 factory = new MyFactory2();
        MyInterface myi = factory.produceOne();
        myi.print();
    }
}
