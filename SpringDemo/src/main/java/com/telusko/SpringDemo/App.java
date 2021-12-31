package com.telusko.SpringDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Alien alien1 = (Alien) applicationContext.getBean("alien");
        alien1.code();
        System.out.println(alien1.getAge());
    }
}
