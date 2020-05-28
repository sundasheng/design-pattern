package com.example.recursive;

import java.util.StringJoiner;

public class RecursiveCount {

    private static int count(int a) {
        a++;
        if (a < 10) {
            return count(a);
        } else {
            return a;
        }
    }

    private static int fibonacciSequence(int a) {
        int b;
        if (a <= 2) {
            b=1;
        }else{
            b = fibonacciSequence(a - 1) + fibonacciSequence(a - 2);
        }
//        System.out.print(" " + b);

        return b;
    }

    public static void main(String[] args) {
//        System.out.println(count(1));
        System.out.println(fibonacciSequence(3));
    }
}
