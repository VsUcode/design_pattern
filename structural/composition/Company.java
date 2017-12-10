package com.vsu.structural.composition;

/**
 * Created by vsu on 2017/12/10.
 */


/**
 * Component：是组合中的对象声明接口，
 * 在适当的情况下，实现所有类共有接口的默认行为。声明一个接口用于访问和管理Component子部件。
 */
public abstract class Company {
    private String name;

    public Company() {
    }

    public Company(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected abstract void add(Company company);

    protected abstract void romove(Company company);

    protected abstract void display(int depth);
}
