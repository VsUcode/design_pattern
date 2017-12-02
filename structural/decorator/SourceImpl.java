package com.vsu.structural.decorator;

/**
 * Created by vsu on 2017/12/02.
 */
public class SourceImpl implements Source{
    @Override
    public void method() {
        System.out.println("this is original method");
    }
}
