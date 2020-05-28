package com.example.designpattern.singleton;

/**
 * @author sunjing
 * @create 2019-09-26 10:47
 **/
public class DclSingleton {

    private volatile static DclSingleton instance;

    private DclSingleton() {
    }

    public static DclSingleton getInstance(){
        if(instance == null){
            synchronized (DclSingleton.class){
                if(instance == null){
                    instance = new DclSingleton();
                }
            }
        }
        return instance;
    }
}
