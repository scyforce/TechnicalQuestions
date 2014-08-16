package com.interview.designpattern.abstractfactory;

class IntelFactory implements CPUFactory {
    public CPU produceCPU() {
        return new IntelCPU();
    }
}