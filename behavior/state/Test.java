package com.vsu.behavior.state;

/**
 * Created by vsu on 2017/12/24.
 */


/**
 * 状态模式
 */


class State{
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state1) {
        this.state = state1;
    }

    public void method1(){
        System.out.println("method1");
    }

    public void method2(){
        System.out.println("method2");
    }
}


class Content{
    private State state = null;

    public Content(State state){
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void method(){
        System.out.println("状态为： " + state.getState());
        if (state.getState().equals("state1")){
            state.method1();
        }else if(state.getState().equals("state2")){
            state.method2();
        }
    }
}


public class Test {
    public static void main(String[] args) {
        State state = new State();
        Content content = new Content(state);
        state.setState("state1");
        content.method();

        state.setState("state2");
        content.method();
        /*
        状态为： state1
        method1
        状态为： state2
        method2

         */
    }
}
