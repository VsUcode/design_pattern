package com.vsu.structural.proxy;

/**
 * Created by vsu on 2017/12/04.
 */
public class SourceImpl implements Source {
    @Override
    public void method() {
        System.out.println("this is original method");
    }
}
