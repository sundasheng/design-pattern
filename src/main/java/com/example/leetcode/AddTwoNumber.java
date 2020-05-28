package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AddTwoNumber
 * @Description
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
