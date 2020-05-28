package com.example.designpattern.adapter;

/**
 * @author sunjing
 * @create 2019-09-27 19:25
 **/
public class AdapterTest {
    public static void main(String[] args) {
        ConcreteTarget concreteTarget = new ConcreteTarget();
        concreteTarget.request();
        ClassAdapter adapter = new ClassAdapter();
        adapter.request();
        ObjectAdapt objectAdapt = new ObjectAdapt();
        objectAdapt.request();
    }
}
