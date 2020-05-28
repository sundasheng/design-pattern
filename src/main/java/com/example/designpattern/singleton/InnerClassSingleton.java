package com.example.designpattern.singleton;

/**
 * @author sunjing
 * @create 2019-09-26 10:55
 **/
public class InnerClassSingleton {

    private static class Holder{
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    private InnerClassSingleton(){

    }

    public static InnerClassSingleton getInstance(){
        return Holder.INSTANCE;
    }

}
