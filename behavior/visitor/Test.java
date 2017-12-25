package com.vsu.behavior.visitor;

/**
 * Created by vsu on 2017/12/25.
 */


/**
 * 访问者模式
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Element 定义一个接受访问操作(accept())，它以一个访问者(Visitor)作为参数。
 */
abstract class Element {
    public abstract void accept(IVisitor visitor);
    public abstract void doSomething();
}


/**
 * ConcreteElement 具体元素，实现了抽象元素(Element)所定义的接受操作接口
 */
class ConcreteElement1 extends Element{
    public void doSomething(){
        System.out.println("这是元素1");
    }
    public void accept(IVisitor visitor){
        visitor.visit(this);
    }
}

class ConcreteElement2 extends Element{
    public void doSomething(){
        System.out.println("这是元素2");
    }
    public void accept(IVisitor visitor){
        visitor.visit(this);
    }
}


/**
 * Visitor 抽象访问者角色，为该对象结构中具体元素角色声明一个访问操作接口。
 * 该操作接口的名字和参数标识了发送访问请求给具体访问者的具体元素角色，这样访问者就可以通过该元素角色的特定接口直接访问它。
 */
interface IVisitor{
    public void visit(ConcreteElement1 cet1);
    public void visit(ConcreteElement2 cet2);
}


/**
 * ConcreteVisitor.具体访问者角色，实现Visitor声明的接口。
 */
class ConcreteVisitor implements IVisitor{
    public void visit(ConcreteElement1 cet1){
        cet1.doSomething();
    }
    public void visit(ConcreteElement2 cet2){
        cet2.doSomething();
    }
}


/**
 * ObjectStructure 结构对象角色，这是使用访问者模式必备的角色。它具备以下特性：能枚举它的元素；
 * 可以提供一个高层接口以允许访问者访问它的元素；如有需要，可以设计成一个复合对象或者一个聚集（如一个列表或无序集合）。
 */
class ObjectStruture{
    public static List<Element> getList(){
        List<Element>list = new ArrayList<Element>();
        Random ran = new Random();
        for(int i = 0 ; i < 10 ; i ++){
            int a=ran.nextInt(100);
            if(a>50){
                list.add (new ConcreteElement1());
            }else{
                list.add (new ConcreteElement2());
            }
        }
        return list;
    }
}




public class Test {
    public static void main (String[]args){
        List<Element> list = ObjectStruture.getList();
        for(Element e : list){
            e.accept(new ConcreteVisitor());
        }
    }
}
