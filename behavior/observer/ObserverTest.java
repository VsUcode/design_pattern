package com.vsu.behavior.observer;

import org.junit.jupiter.api.Test;

import java.util.Enumeration;
import java.util.Vector;

/** 观察者模式
 * Created by vsu on 2017/12/18.
 */

interface Observer{
    void update();
}


class ObserverOne implements Observer{

    @Override
    public void update() {
        System.out.println("observerone has received");
    }
}


class ObserverTwo implements Observer{

    @Override
    public void update() {
        System.out.println("observertwo has received");
    }
}


interface Subject{

    /*增加观察者*/
    void add(Observer observer);

    /*删除观察者*/
    void del(Observer observer);

    /*通知所有的观察者*/
    void notifyObservers();

    /*自身的操作*/
    void operation();
}


abstract class AbstractSubject implements Subject {

    private Vector<Observer> vector = new Vector<Observer>();
    @Override
    public void add(Observer observer) {
        vector.add(observer);
    }

    @Override
    public void del(Observer observer) {
        vector.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Enumeration<Observer> enumo = vector.elements();
        while(enumo.hasMoreElements()){
            enumo.nextElement().update();
        }
    }
}

class MySubject extends AbstractSubject {

    @Override
    public void operation() {
        System.out.println("update self!");
        notifyObservers();
    }

}

public class ObserverTest {

    public static void main(String[] args) {
        Subject sub = new MySubject();
        sub.add(new ObserverOne());
        sub.add(new ObserverTwo());

        sub.operation();
        /*
        update self!
        observerone has received
        observertwo has received
         */
    }
}
