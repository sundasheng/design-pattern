package com.example.algorithm.string;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author sunjing
 * @create 2019-12-20 16:27
 **/
public class StringSort {

    public static void main(String[] args) {

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("输入：");
            String str = sc.nextLine();
            if ("exit".equals(str)) {
                break;
            }
            int[] flags = new int[str.length()];
            String letter = "", number = "";
            /**
             * 将数字和字母分开，并记录原来位置
             */
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                /**
                 * ascii码 48~57 对应数组0~9  65~90对应A~Z  97~122对应a~z
                 */
                if (c > 47 && c < 58) {
                    number += c;
                    flags[i] = 0;
                } else if (c > 64 && c < 91) {
                    letter += c;
                    flags[i] = 1;
                } else if (c > 96 && c < 123) {
                    letter += c;
                    flags[i] = 1;
                } else {
                    throw new IllegalArgumentException("输入包含非数字或字母！");
                }
            }
            char[] letterArr = letter.toCharArray();
            char[] numberArr = number.toCharArray();
            Arrays.sort(letterArr);
            Arrays.sort(numberArr);

            int numberIndex = 0;
            int letterIndex = 0;
            char[] result = new char[str.length()];
            for(int i = 0;i<str.length();i++){
                if(flags[i]==0){
                    result[i]=numberArr[numberIndex++];
                }else{
                    result[i] = letterArr[letterIndex++];
                }
            }
            System.out.println(String.valueOf(result));
        }
    }
}
