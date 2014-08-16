package com.interview.designpattern.abstractfactory;

class AMDFactory implements CPUFactory {
    public CPU produceCPU() {
        return new AMDCPU();
    }
}