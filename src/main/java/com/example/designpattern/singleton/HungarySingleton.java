package com.example.designpattern.singleton;

/**
 * @author sunjing
 * @create 2019-09-26 10:38
 **/
public class HungarySingleton {

    private static HungarySingleton INSTANCE = new HungarySingleton();

    private HungarySingleton() {
    }

    public static HungarySingleton getINSTANCE() {
        return INSTANCE;
    }
}
