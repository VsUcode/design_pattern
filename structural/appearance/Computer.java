package com.vsu.structural.appearance;

/**
 * Created by vsu on 2017/12/06.
 */
public class Computer {

    private Cpu cpu = null;
    private Memory memory = null;
    private Disk disk = null;

    public Computer() {
        cpu = new Cpu();
        memory = new Memory();
        disk = new Disk();
    }

    public void startup() {
        System.out.println("start the computer!");
        cpu.startup();
        memory.startup();
        disk.startup();
        System.out.println("start computer finished!");
    }

    public void shutdown() {
        System.out.println("begin to close the computer!");
        cpu.shutdown();
        memory.shutdown();
        disk.shutdown();
        System.out.println("computer closed!");
    }





    public static void main(String[] args) {

        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }
}
