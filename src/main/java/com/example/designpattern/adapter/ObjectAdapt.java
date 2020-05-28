package com.example.designpattern.adapter;

/**
 * @author sunjing
 * @create 2019-09-27 19:31
 **/
public class ObjectAdapt implements Target {

    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.adapteeRequest();
    }
}
