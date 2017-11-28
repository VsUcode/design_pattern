package com.vsu.creational.singleton;

/**
 * Created by vsu on 2017/11/28.
 */


/**
 * 双重校验锁
 *
 * 加锁的懒汉模式看起来即解决了线程并发问题，又实现了延迟加载，然而它存在着性能问题，依然不够完美。
 * synchronized修饰的同步方法比一般方法要慢很多，如果多次调用getInstance()，累积的性能损耗就比较大了。
 *
 */


/**
 *线程不安全
 * 假如两个线程A、B， A执行了if (instance == null)语句，它会认为单例对象没有创建，
 * 此时线程切到B也执行了同样的语句，B也认为单例对象没有创建，然后两个线程依次执行同步代码块，并分别创建了一个单例对象。
 *为了解决这个问题，还需要在同步代码块中增加if (instance == null)语句，也就是上面看到的代码2。
 */
class Singleton {
    private static Singleton instance = null;
    private Singleton(){}
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {//2
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}

/**
 *  这里要提到Java中的指令重排优化。所谓指令重排优化是指在不改变原语义的情况下，通过调整指令的执行顺序让程序运行的更快。
 *  JVM中并没有规定编译器优化相关的内容，也就是说JVM可以自由的进行指令重排序的优化。
 *这个问题的关键就在于由于指令重排优化的存在，导致初始化Singleton和将对象地址赋给instance字段的顺序是不确定的。
 * 在某个线程创建单例对象时，在构造方法被调用之前，就为该对象分配了内存空间并将对象的字段设置为默认值。
 * 此时就可以将分配的内存地址赋值给instance字段了，然而该对象可能还没有初始化。若紧接着另外一个线程来调用getInstance，取到的就是状态不正确的对象，程序就会出错。
 * 以上就是双重校验锁会失效的原因，不过还好在JDK1.5及之后版本增加了volatile关键字
 */



/**
 * 1.5 volatile
 */
public class SingletonThree {

    private static volatile SingletonThree singletonThree = null;

    private SingletonThree(){}

    public static SingletonThree NewInstance(){
        if ( singletonThree == null){
            synchronized (SingletonThree.class){
                if (singletonThree == null){
                    singletonThree = new SingletonThree();
                }
            }
        }

        return singletonThree;
    }
}
