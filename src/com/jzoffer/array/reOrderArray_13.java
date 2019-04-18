package com.jzoffer.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengcheng
 * @date 2019/4/18 - 11:38
 * @content:
 */
public class reOrderArray_13 {

    public static void reOrderArray(int[] array){
        if(array == null || array.length < 1){
            return;
        }

        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 == 0){
                // 偶数
                list2.add(array[i]);
            }else{
                // 奇数
                list1.add(array[i]);
            }
        }

        for(int i = 0; i < list1.size(); i++){
            array[i] = list1.get(i);
        }
        for(int i = 0; i < list2.size(); i++){
            array[i + list1.size()] = list2.get(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        reOrderArray(arr);
    }
}
