package com.interview.designpattern.facade;

 
/*
 * Facade design pattern hides complexity of a task and provides a simple interface. 
 * 
 * A very good example is the startup of a computer. When a computer starts up, it involves the work of cpu, memory, hard drive, etc. 
 * 
 * To make it easy to use for users, we can add a facade which wrap the complexity of the task, 
 * 
 * and provide one simple interface instead.
 */
class Computer {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;
 
    public Computer() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }
 
    public void run() {
        cpu.processData();
        memory.load();
        hardDrive.readdata();
    }
}
