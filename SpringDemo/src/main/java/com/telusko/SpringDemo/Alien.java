package com.telusko.SpringDemo;

public class Alien {

    private int age;
    private Computer computer;

    public Alien(int age) {
        this.age = age;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Age Setter is called.....");
        this.age = age;
    }
    public void code(){
        System.out.println("Alien is coding.....");
        computer.compile();
    }
}
