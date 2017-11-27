package com.vsu.creational.abstract_factory;

import com.vsu.creational.factory_method.MyInterface;

/**
 * Created by vsu on 2017/11/27.
 */


/**
 * 使用工厂方法模式的接口 和 具体实现类
 */
public interface Provider {
    public MyInterface produce();
}
