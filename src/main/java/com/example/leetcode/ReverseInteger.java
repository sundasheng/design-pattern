package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ReverseInteger
 * @Description
 * @Author sunjing
 * @Date 2020/5/29 15:56
 * @Version 1.0
 */
public class ReverseInteger {
    public static int reverse(int x) {
        List<Integer> list = new ArrayList<>();
        boolean flag = true;
        while (flag) {
            list.add(x % 10);
            flag = (x = x / 10) != 0;
        }
        int r = 0;
        long a;
        int b;
        for (Integer integer : list) {
            a = (long)r * 10;
            if((int)a!=a){
                return 0;
            }
            b = integer;
            r = (int)a + b;
            if (((a ^ r) & (b ^ r)) < 0) {
                return 0;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
