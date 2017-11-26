package com.vsu.creational.factory_method;

/**静态工厂方法模式，将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可
 * Created by vsu on 2017/11/26.
 */



class MyFactory3 {

    public static MyInterface produceOne() {
        return new MyClassOne();
    }

    public static MyInterface produceTwo() {
        return new MyClassTwo();
    }

}



public class Factory3 {
    public static void main(String[] args){
        MyInterface myi = MyFactory3.produceOne();
        myi.print();
    }
}
