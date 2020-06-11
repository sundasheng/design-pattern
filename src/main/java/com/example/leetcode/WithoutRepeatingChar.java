package com.example.leetcode;

/**
 * @ClassName WithoutRepeatingChar
 * @Description 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author sunjing
 * @Date 2020/5/27 17:44
 * @Version 1.0
 */
public class WithoutRepeatingChar {

    public static int count(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        if (chars.length == 1) {
            return 1;
        }
        int flag = 0;
        int a;
        for (int i = 1; i < chars.length; i++) {
            for (int j = i - 1; j >= flag; j--) {
                if (chars[i] == chars[j]) {
                    flag = j + 1;
                    a = i - j;
                    if (result < a) {
                        result = a;
                    }
                    break;
                } else {
                    a = i - j + 1;
                    if (result < a) {
                        result = a;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(count("av"));
    }
}
