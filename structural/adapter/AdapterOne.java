package com.vsu.structural.adapter;

/**
 * Created by vsu on 2017/12/01.
 */


/**
 * 类的适配器模式核心思想就是：
 * 有一个Source类，拥有一个方法，待适配，目标接口是Targetable，通过Adapter类，将Source的功能扩展到Targetable里。
 */
public class AdapterOne {

    static class Adapter extends Source implements Targetable{

        @Override
        public void method2() {
            System.out.println("this is targetable method");
        }
    }


    public static void main(String[] args) {

        Targetable targetable = new Adapter();
        targetable.method1();//this is original method

        targetable.method2();//this is targetable method

    }
}
