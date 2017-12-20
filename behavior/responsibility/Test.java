package com.vsu.behavior.responsibility;

/**
 * Created by vsu on 2017/12/20.
 */



/**
 * 责任链模式
 */

interface Handler{
    void operator();
}

abstract class AbstractHandler{

    Handler handler = null;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}

class MyHandler extends AbstractHandler implements Handler{

    private String name;

    public MyHandler(String name){
        this.name = name;
    }

    @Override
    public void operator() {
        System.out.println(name + "  deal");
        if (this.getHandler() != null){
            this.getHandler().operator();
        }
    }
}


public class Test {
    public static void main(String[] args) {
        MyHandler h1 = new MyHandler("h1");
        MyHandler h2 = new MyHandler("h2");
        MyHandler h3 = new MyHandler("h3");

        h1.setHandler(h2);
        h2.setHandler(h3);

        h1.operator();
    }
}
