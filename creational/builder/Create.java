package com.vsu.creational.builder;

/**
 * Created by vsu on 2017/11/29.
 */


/**
 * 建造者模式
 *   抽象接口  --builder
 *   实现接口  --concretebuilder
 *   调用具体实现方法  --director
 *   要创建的复杂对象  --product
 */


/**
 *  product
 */
class Person{

    private String head;
    private String body;
    private String food;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}


/**
 *  builder
 */
interface PersonBuilder{
    void buildHead();
    void buildBody();
    void buildFoot();

    Person buildPerson();
}

/**
 * concreteBuilder
 */
class ConcreteBuilder implements PersonBuilder{

    Person person = null;

    public ConcreteBuilder(){
        person = new Person();
    }

    @Override
    public void buildHead() {
        person.setHead("创建头部");
    }

    @Override
    public void buildBody() {
        person.setBody("创建身体");
    }

    @Override
    public void buildFoot() {
        person.setFood("创建脚");
    }

    @Override
    public Person buildPerson() {
        return person;
    }
}


/**
 *  director
 */
class PersonDirector{

    public Person constructPerson(PersonBuilder personBuilder){
        personBuilder.buildHead();
        personBuilder.buildBody();
        personBuilder.buildFoot();

        return personBuilder.buildPerson();
    }
}



public class Create {

    public static void main(String[] args) {

        PersonDirector personDirector = new PersonDirector();

        Person person = personDirector.constructPerson(new ConcreteBuilder());

        System.out.println(person.getHead());
        System.out.println(person.getBody());
        System.out.println(person.getFood());
    }
}
