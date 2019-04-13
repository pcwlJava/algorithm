package com.dailypractice.string;

import java.util.HashSet;

/**
 * @author pengcheng
 * @date 2019/4/12 - 17:04
 * @content:
 */
public class 字符串排列_去重 {

    public static void printAllSort(String string){
        if(string == null){
            return;
        }

        char[] chars = string.toCharArray();
        if(chars.length > 0){
            printAllSort(0, chars);
        }
    }

    // 对i及i以后的字符进行全排列
    public static void printAllSort(int i, char[] chars){
        // 递归终止条件
        if(i == chars.length){
            System.out.println(String.valueOf(chars));
        }

        // 用于保证每次交换的字符不存在重复的字符
        HashSet<Character> set = new HashSet<>();
        for(int j = i; j < chars.length; j++){
            if(!set.contains(chars[j])){
                set.add(chars[j]);
                swap(i, j, chars);   // 第 i 个位置有 i ~ (n - 1) 种选择。n 为字符串的长度
                printAllSort(i + 1, chars);
                swap(i, j, chars);   // 保证 i 后面的字符每次都是和 i 位置上的元素进行的交换，还需要将 i 和 j 交换回来
            }
        }
    }

    public static void swap(int i, int j, char[] chars){
        int temp = chars[i];
        chars[i] = chars[j];
        chars[j] = chars[i];
    }

    public static void main(String[] args) {
        printAllSort("abcc");
    }
}
