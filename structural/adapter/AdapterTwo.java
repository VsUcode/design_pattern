package com.vsu.structural.adapter;

/**
 * Created by vsu on 2017/12/01.
 */


/**
 * 对象的适配器模式的基本思路和类的适配器模式相同，
 * 只是将Adapter类作修改成Wrapper，这次不继承Source类，而是持有Source类的实例，以达到解决兼容性的问题。
 */
public class AdapterTwo {

    static class Adapter implements Targetable{

        private Source source = null;

        public Adapter(Source source){
            super();
            this.source = source;
        }

        @Override
        public void method1() {
            source.method1();
        }

        @Override
        public void method2() {
            System.out.println("this is targetable method");
        }
    }


    public static void main(String[] args) {
        Source source = new Source();
        Targetable targetable = new Adapter(source);

        targetable.method1();//this is original method

        targetable.method2();//this is targetable method

    }
}
