package com.example.leetcode;

/**
 * @ClassName WithoutRepeatingChar
 * @Description
 * @Author sunjing
 * @Date 2020/5/27 17:44
 * @Version 1.0
 */
public class WithoutRepeatingChar {

    public static int count(String s){
        char[] chars = s.toCharArray();
        int result= 0;
        for(int i=0;i<chars.length-1;i++){
            for(int j = i+1;j < chars.length;j++){
                if(chars[i]==chars[j]){
                    i=j;
                    break;
                }
                int a = j-i+1;
                if(result<a){
                    result = a;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(count("abcabcd"));
    }
}
