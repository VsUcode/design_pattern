package com.vsu.behavior.mediator;

/** 中介者模式
 * Created by vsu on 2017/12/27.
 */


import java.util.Hashtable;

/**
 * 同事类族
 */
abstract class AbstractColleague{
    protected AbstractMediator mediator = null;
    /*既然有中介者，那么每个具体同事必然要与中介者有联系，
     * 否则就没必要存在于 这个系统当中，这里的构造函数相当
     * 于向该系统中注册一个中介者，以取得联系
     */
    public AbstractColleague(AbstractMediator mediator){
        this.mediator = mediator;
    }

    // 在抽象同事类中添加用于与中介者取得联系（即注册）的方法
    public void setMediator(AbstractMediator mediator){
        this.mediator = mediator;
    }
}

//具体同事A
class ColleagueA extends AbstractColleague{

    //每个具体同事都能通过父类构造函数与中介者取得联系
    public ColleagueA(AbstractMediator mediator) {
        super(mediator);
    }

    //每个具体同事必然有自己分内的事，没必要与外界相关联
    public void self(){
        System.out.println("同事A ---- 自己分内的事");
    }

    //每个具体的同事总有需要与外界交互的操作，通过中介者来处理这些逻辑并安排工作
    public void out(){
        System.out.println("同事A ---- 请求同事B做好分内的工作");
        super.mediator.execute("ColleagueB", "self");
    }
}

//具体同事B
class ColleagueB extends AbstractColleague{

    //每个具体同事都能通过父类构造函数与中介者取得联系
    public ColleagueB(AbstractMediator mediator) {
        super(mediator);
    }

    //每个具体同事必然有自己分内的事，没必要与外界相关联
    public void self(){
        System.out.println("同事B ---- 自己分内的事");
    }

    //每个具体的同事总有需要与外界交互的操作，通过中介者来处理这些逻辑并安排工作
    public void out(){
        System.out.println("同事B ---- 请求同事A做好分内的工作");
        super.mediator.execute("ColleagueA", "self");
    }
}


/**
 * 中介者类族
 */
abstract class AbstractMediator{
    //中介者肯定需要保持有若干同事的联系方式
    protected Hashtable<String, AbstractColleague> colleagues = new Hashtable<>();

    //中介者可以动态地与某个同事建立联系
    public void addColleague(String name, AbstractColleague c){
        this.colleagues.put(name, c);
    }

    //中介者可以动态地撤销与某个同事的联系
    public void deleteColleague(String name){
        this.colleagues.remove(name);
    }

    //中介者必须具备在同事之间处理逻辑、分配任务、促进交流的操作
    public abstract void execute(String name, String method);
}

//具体中介者
class Mediator extends AbstractMediator{

    //中介者最重要的功能，来回奔波与各个同事之间
    @Override
    public void execute(String name, String method) {
        if ("self".equals(method)){//做好各自分内的事
            if("ColleagueA".equals(name)){
                ColleagueA colleagueA = (ColleagueA) super.colleagues.get("ColleagueA");
                colleagueA.self();
            }else {
                ColleagueB colleagueB = (ColleagueB) super.colleagues.get("ColleagueB");
                colleagueB.self();
            }
        }else {//与其他同事合作
            if("ColleagueA".equals(name)){
                ColleagueA colleagueA = (ColleagueA) super.colleagues.get("ColleagueA");
                colleagueA.out();
            }else {
                ColleagueB colleagueB = (ColleagueB) super.colleagues.get("ColleagueB");
                colleagueB.out();
            }
        }
    }
}



public class Test {
    public static void main(String[] args) {

        //创建一个中介者
        AbstractMediator mediator = new Mediator();

        //创建两个同事
        ColleagueA colleagueA = new ColleagueA(mediator);
        ColleagueB colleagueB = new ColleagueB(mediator);

        //中介者分别与每个同事建立联系
        mediator.addColleague("ColleagueA", colleagueA);
        mediator.addColleague("ColleagueB", colleagueB);

        //同事们开始工作
        colleagueA.self();
        colleagueA.out();
        System.out.println("======================合作愉快，任务完成！\n");

        colleagueB.self();
        colleagueB.out();
        System.out.println("======================合作愉快，任务完成！");
        /*
        同事A ---- 自己分内的事
        同事A ---- 请求同事B做好分内的工作
        同事B ---- 自己分内的事
        ======================合作愉快，任务完成！

        同事B ---- 自己分内的事
        同事B ---- 请求同事A做好分内的工作
        同事A ---- 自己分内的事
        ======================合作愉快，任务完成！
         */
    }
}
