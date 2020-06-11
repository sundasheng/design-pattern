package com.example.leetcode;

/**
 * @ClassName Atoi
 * @Description 8. 字符串转换整数 (atoi)
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * <p>
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 * <p>
 * 提示：
 * <p>
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author sunjing
 * @Date 2020/6/10 9:09
 * @Version 1.0
 */
public class Atoi {

    public static int myAtoi(String str) {
        str = str.trim();
        if (str.length() < 1) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int start = 0, result = 0;
        boolean flag = true;
        if (chars[0] == '-') {
            flag = false;
            start = 1;
        } else if (chars[0] == '+') {
            start = 1;
        }else if(Character.isDigit(chars[0])){
            flag = true;
        }else {
            return 0;
        }
        int c;
        for (int i = start; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                c = chars[i] - '0';
                if (flag) {
                    if (i < 9) {
                        result = result * 10 + c;
                    } else {
                        if (Integer.MAX_VALUE / 10 < result ||
                                (Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < (chars[i] - '0'))) {
                            return Integer.MAX_VALUE;
                        } else {
                            result = result * 10 + c;
                        }
                    }
                } else {
                    c = c * -1;
                    if (i < 10) {
                        result = result * 10 + c;
                    } else {
                        if (Integer.MIN_VALUE / 10 > result ||
                                (Integer.MIN_VALUE / 10 == result && Integer.MIN_VALUE % 10 > -(chars[i] - '0'))) {
                            return Integer.MIN_VALUE;
                        } else {
                            result = result * 10 + c;
                        }
                    }
                }


            } else {
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483649"));
    }
}