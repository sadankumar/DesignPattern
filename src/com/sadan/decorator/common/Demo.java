package com.sadan.decorator.common;

public abstract class Demo {
    private int clipNumber;

    public Demo(int clipNumber) {
        this.clipNumber = clipNumber;
    }

    public void run() {
        System.out.format("\nClip %02d demo\n", this.clipNumber);
        this.implementation();
        System.out.println("--------------------");
    }

    protected abstract void implementation();
}
