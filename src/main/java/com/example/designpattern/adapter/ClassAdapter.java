package com.example.designpattern.adapter;

/**
 * @author sunjing
 * @create 2019-09-27 19:25
 **/
public class ClassAdapter extends Adaptee implements Target {
    @Override
    public void request() {
        adapteeRequest();
    }
}
