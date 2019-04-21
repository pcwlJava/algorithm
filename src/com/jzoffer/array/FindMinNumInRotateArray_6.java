package com.jzoffer.array;

import java.util.Arrays;

/**
 * @author pengcheng
 * @date 2019/4/18 - 9:51
 * @content:
 */
public class FindMinNumInRotateArray_6 {

    public static int minNumberInRotateArray(int[] array) {
        if(array == null || array.length < 1){
            return 0;
        }

        int minNum = -1;

        for(int i = 0; i < array.length - 1; i++){
            if(array[i + 1] >= array[i]){
                continue;
            }else{
                minNum =  array[i + 1];
            }
        }
        System.out.println(minNum);
        return minNum;
    }

    public static int minNumberInRotateArray2(int[] array) {
        if (array == null || array.length < 1) {
            return 0;
        }

        Arrays.sort(array);
        System.out.println(array[0]);
        return array[0];
    }

    public static void main(String[] args) {
        int[] array = {3,4,5,1,2};
        minNumberInRotateArray2(array);
    }
}
