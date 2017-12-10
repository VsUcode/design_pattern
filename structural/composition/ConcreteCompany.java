package com.vsu.structural.composition;

/**
 * Created by vsu on 2017/12/10.
 */


import java.util.ArrayList;
import java.util.List;

/**
 * Composite：定义有枝节点行为，用来存储子部件，在Component接口中实现与子部件有关操作，如增加(add)和删除(remove)等。
 */
public class ConcreteCompany extends Company {

    private List<Company> cList;

    public ConcreteCompany() {
        cList = new ArrayList();
    }

    public ConcreteCompany(String name) {
        super(name);
        cList = new ArrayList();
    }

    @Override
    protected void add(Company company) {
        cList.add(company);
    }

    @Override
    protected void display(int depth) {

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < depth; i++) {
            sb.append("-");
        }
        System.out.println(new String(sb) + this.getName());
        for (Company c : cList) {
            c.display(depth + 2);
        }
    }

    @Override
    protected void romove(Company company) {
        cList.remove(company);
    }
}
