package com.vsu.creational.abstract_factory;

/**
 * Created by vsu on 2017/11/27.
 */


import com.vsu.creational.factory_method.MyClassOne;
import com.vsu.creational.factory_method.MyInterface;

/**
 * 返回实现类1的引用
 */
public class FactoryOne implements Provider{
    @Override
    public MyInterface produce() {
        return new MyClassOne();
    }


    static class Test{

        public static void main(String[] args) {
            Provider provider = new FactoryOne();
            MyInterface m = provider.produce();
            m.print();
        }

    }
}
