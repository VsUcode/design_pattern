package com.vsu.creational.abstract_factory;

/**
 * Created by vsu on 2017/11/27.
 */


import com.vsu.creational.factory_method.MyClassTwo;
import com.vsu.creational.factory_method.MyInterface;

/**
 * 返回实现类2 的引用
 */
public class FactoryTwo implements Provider{

    @Override
    public MyInterface produce() {
        return new MyClassTwo();
    }



    static class Test{
        public static void main(String[] args) {
            Provider provider = new FactoryTwo();
            MyInterface m = provider.produce();
            m.print();
        }
    }
}
