package com.example.algorithm.string;

import java.util.Scanner;

/**
 * @author sunjing
 * @create 2019-12-18 17:31
 **/
public class StringMatching {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入:");
        /**
         * 读取输入1
         */
        String str1 = sc.nextLine();
        /**
         * 读取输入2
         */
        String str2 = sc.nextLine();
        /**
         * 除去字符串中的空格
         */
        str1 = str1.trim().replaceAll(" ","");
        str2 = str2.trim().replaceAll(" ","");

        int start = 0;
        int count = 0;

        while (str2.length()<=str1.length()-start){
            int index = str1.indexOf(str2,start);
            if(-1!=index){
                count++;
                start = index+1;
            }else{
                start++;
            }
        }
        System.out.println("输出:"+count);
    }

}
