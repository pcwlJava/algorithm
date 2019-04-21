package com.handwrite.查找;

/**
 * @author pengcheng
 * @date 2019/4/21 - 14:33
 * @content:
 */
public class BinarySearchWithRecursion {

    public static int binarySearch(int[] array, int key){
        if(array.length < 1){
            return -1;
        }

        int index = binarySearch(array, key, 0, array.length - 1);

        return index;
    }

    public static int binarySearch(int[] array, int key, int start, int end){
        int mid = (end - start) / 2 + start;
        // 递归终止条件
        if(array[mid] == key){
            return mid;
        }

        if(start >= end){
            return -1;
        }else if(key > array[mid]){
            return binarySearch(array, key, mid + 1, end);
        }else if(key < array[mid]){
            return binarySearch(array, key, start, mid - 1);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(binarySearch(arr, 6));
    }
}
