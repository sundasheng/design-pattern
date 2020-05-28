package com.example.leetcode;

import java.util.Arrays;

/**
 * @ClassName TwoSum
 * @Description
 * @Author sunjing
 * @Date 2020/5/27 16:03
 * @Version 1.0
 */
public class TwoSum {

    public static int[] towSum(int[] nums, int target){
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,0};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target =26;
        System.out.println(Arrays.toString(towSum(nums,target)));
    }
}
