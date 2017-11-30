package com.vsu.creational.prototype;

/**
 * Created by vsu on 2017/11/30.
 */


import java.io.*;

/**
 *  原型模式
 */
public class Prototype {

    static class PrototypeTest implements Cloneable, Serializable{

        private static final long serializableUID = 5552L;
        private int base;
        private Integer obj;

        /**
         * 浅复制
         */
        public Object clone() throws CloneNotSupportedException {
            // 因为Cloneable接口是个空接口，你可以任意定义实现类的方法名
            // 如cloneA或者cloneB，因为此处的重点是super.clone()这句话
            // super.clone()调用的是Object的clone()方法
            // 而在Object类中，clone()是native（本地方法）的
            PrototypeTest proto = (PrototypeTest) super.clone();
            return proto;
        }

        /**
         * 深复制
         */
        public Object deepClone() throws IOException, ClassNotFoundException {

        /* 写入当前对象的二进制流 */
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

        /* 读出二进制流产生的新对象 */
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return ois.readObject();
        }



        public int getBase() {
            return base;
        }

        public void setBase(int base) {
            this.base = base;
        }

        public Integer getObj() {
            return obj;
        }

        public void setObj(Integer obj) {
            this.obj = obj;
        }
    }



    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        PrototypeTest prototypeTest = new PrototypeTest();

        prototypeTest.setBase(1);
        prototypeTest.setObj(new Integer(2));

        //浅复制
        PrototypeTest prototype1 = (PrototypeTest) prototypeTest.clone();

        //深复制
        PrototypeTest prototype2 = (PrototypeTest) prototypeTest.deepClone();

        System.out.println("浅复制" + (prototype1.getObj() == prototypeTest.getObj()) );//浅复制true
        System.out.println("深复制" + (prototype2.getObj() == prototypeTest.getObj()) );//深复制false

    }
}
