package com.example.designpattern.singleton;

/**
 * @author sunjing
 * @create 2019-09-26 10:43
 **/
public class LazySingleton {

    private volatile static LazySingleton INSTANCE;

    private LazySingleton() {
    }

    public static synchronized LazySingleton getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }
}
