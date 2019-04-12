package com.leetcode.arrays;

/**
 * @author pengcheng
 * @date 2019/4/5 - 12:49
 * @content: 两数之和问题
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target){

        int[] arr = new int[2];

        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                   arr[0] = i;
                   arr[1] = j;
                   return arr;
                }
            }
        }
        return arr;
    }

}
