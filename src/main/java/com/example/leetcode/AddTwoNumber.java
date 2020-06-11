package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AddTwoNumber
 * @Description 2.两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author sunjing
 * @Date 2020/5/27 16:16
 * @Version 1.0
 */
public class AddTwoNumber {
    public static ListNode addTwoNumber(ListNode l1,ListNode l2){
        int val = l1.val+l2.val;
        int carry = val/10;
        val = val%10;
        ListNode result = new ListNode(val);
        ListNode a1 = l1.next;
        ListNode a2 = l2.next;
        ListNode nextResult = result;
        while(!(a1==null&&a2==null)){
            int value = 0;
            if(a1!=null){
                value+=a1.val;
                a1 = a1.next;
            }
            if(a2!=null){
                value+=a2.val;
                a2 = a2.next;
            }
            value+=carry;
            carry = value/10;
            nextResult.next = new ListNode(value%10);
            nextResult = nextResult.next;
        }
        if(carry>0){
            nextResult.next = new ListNode(carry);
        }
        return result;
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }

        @Override
        public String toString() {

            StringBuilder sb = new  StringBuilder("[");
            sb.append(val);
            ListNode node = next;
            while (node!=null){
                sb.append(',').append(node.val);
                node = node.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
        System.out.println(addTwoNumber(l1,l2));

    }

}
