package com.example.designpattern.factory;

/**
 * @author sunjing
 * @create 2019-09-26 14:52
 **/
public class BMWFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new BMW();
    }
}
