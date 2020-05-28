package com.example.designpattern.factory;

/**
 * @author sunjing
 * @create 2019-09-26 15:12
 **/
public class FactoryMethodTest {
    public static void main(String[] args) {
        CarFactory bmwFactory = new BMWFactory();
        System.out.println(bmwFactory.getCar().getName());
    }
}
