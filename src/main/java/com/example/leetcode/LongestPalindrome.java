package com.example.leetcode;

import java.util.Stack;

/**
 * @ClassName LongestPalindrome
 * @Description 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author sunjing
 * @Date 2020/5/28 11:07
 * @Version 1.0
 */
public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        int len = s.length();
        //边界处理
        if (len < 2) {
            return s;
        }
        int max = 1;
        int start = 0;
        boolean[][] dp = new boolean[len][len];
        char[] chars = s.toCharArray();
        //
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    start = i;
                }
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return s.substring(start, start + max);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

}
