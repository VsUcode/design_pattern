package com.vsu.structural.composition;

/**
 * Created by vsu on 2017/12/10.
 */


/**
 * Leaf：在组合中表示叶子结点对象，叶子结点没有子结点。
 */
public class Leaf {

    class HRDepartment extends Company {
        public HRDepartment(String name) {
            super(name);
        }

        @Override
        protected void add(Company company) {
        }

        @Override
        protected void display(int depth) {
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < depth; i++) {
                sb.append("-");
            }
            System.out.println(new String(sb) + this.getName());
        }

        @Override
        protected void romove(Company company) {
        }
    }


    class FinanceDepartment extends Company {
        public FinanceDepartment(String name) {
            super(name);
        }

        @Override
        protected void add(Company company) {
        }

        @Override
        protected void display(int depth) {
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < depth; i++) {
                sb.append("-");
            }
            System.out.println(new String(sb) + this.getName());
        }

        @Override
        protected void romove(Company company) {
        }
    }
}
