package com.example.designpattern.factory;

/**
 * @author sunjing
 * @create 2019-09-26 11:40
 **/
public class SimpleFactory {

    public Car getCar(String carName){
        if("BMW".equals(carName)){
            return new BMW();
        }else if("Benz".equals(carName)){
            return new Benz();
        }else {
            return null;
        }
    }

}
