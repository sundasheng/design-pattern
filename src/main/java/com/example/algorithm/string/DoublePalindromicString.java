package com.example.algorithm.string;

import java.util.Scanner;

/**
 * @author sunjing
 * @create 2019-12-19 8:59
 **/
public class DoublePalindromicString {

    public static void main(String[] args) {

        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.print("输入：");
            String str = sc.nextLine();
            if("exit".equals(str)){
                break;
            }
            String result = "";
            /**
             * 判断偶数个字符
             */
            if (str.length() % 2 == 0) {

                for (int i = 0; i < str.length() / 2; i++) {
                    /**
                     * 判断是否是回文
                     */
                    if (str.charAt(i) == str.charAt(str.length() - i - 1)) {
                        /**
                         * 判断下标为奇数的字符是否与上一个字符相同（双回文）
                         * 字符串：a a b b a a
                         * 下标 ： 0 1 2 3 4 5
                         */
                        if (i % 2 != 0) {
                            if (str.charAt(i - 1) != str.charAt(i)) {
                                result = "false";
                                break;
                            }
                        }
                        /**
                         * 间隔抽取
                         */
                        result += str.charAt(i * 2);
                    } else {
                        result = "false";
                        break;
                    }
                }
            } else {
                result = "false";
            }
            System.out.println(result);
        }

    }
}
