package com.example.designpattern.adapter;

/**
 * @author sunjing
 * @create 2019-09-27 19:23
 **/
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("concreteTarget目标方法");
    }
}
