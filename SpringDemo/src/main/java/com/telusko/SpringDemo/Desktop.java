package com.telusko.SpringDemo;

public class Desktop implements Computer{

    @Override
    public void compile() {
        System.out.println("Desktop code compiled.....");
    }
}
