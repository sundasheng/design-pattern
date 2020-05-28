package com.example.concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunjing
 * @create 2019-10-12 8:48
 **/
public class HeapOom {

    static void heapOom(){
        List<String[]> list = new ArrayList<>();
        for (int i = 0;;i++){
            list.add(new String[1024*1024]);
        }
    }

    static int i = 0;
    static void stackOverflowError(){
        System.out.println(i++);
        stackOverflowError();
    }

    public static void main(String[] args) {
        stackOverflowError();
    }
}
