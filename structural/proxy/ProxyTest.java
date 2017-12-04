package com.vsu.structural.proxy;

/**
 * Created by vsu on 2017/12/04.
 */
public class ProxyTest implements Source {

    SourceImpl source = null;

    public ProxyTest(){
        super();
        source = new SourceImpl();
    }

    @Override
    public void method() {
        before();
        source.method();
        after();
    }

    private void before(){
        System.out.println("before");
    }

    private void after(){
        System.out.println("after");
    }


    public static void main(String[] args) {
        Source source = new ProxyTest();
        source.method();
        /*
        before
        this is original method
        after
         */
    }
}
