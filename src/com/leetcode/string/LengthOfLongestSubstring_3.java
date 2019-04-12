package com.leetcode.string;

import java.util.*;

/**
 * @author pengcheng
 * @date 2019/4/10 - 14:20
 * @content: 无重复字符的最长子串
 */
public class LengthOfLongestSubstring_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        getLengthOfLongestSubstring4(str);
    }

    // 暴力解法：判断所有的子串是否是无重复字符的子串，从最长的开始
    public static int getLengthOfLongestSubstring1(String str){
        if(str == null && str.length() < 1){
            return 0;
        }

        int len = str.length();
        int maxSubLen = 0;
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j <= len; j++){
                if(allUnique(str, i, j)){
                    // j是做完++后再去判断有无重复字符的，所以长度应该是：j - i
                    maxSubLen = Math.max(maxSubLen, j - i);
                }
            }
        }
        System.out.println(maxSubLen);
        return maxSubLen;
    }

    public static boolean allUnique(String str, int start, int end){
        Set<Character> set = new HashSet<>();
        for(int i = start; i < end; i++){
            Character ch = str.charAt(i);
            if(set.contains(ch)){
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    public static int getLengthOfLongestSubstring2(String str) {
        if (str == null && str.length() < 1) {
            return 0;
        }

        int len = str.length();
        int maxSubLen = 0;
        int i = 0;
        int j = 0;
        boolean flag = false;
        for (i = len; i > 0; i--) {
            // 每次从所在位置最大的子串开始遍历
            // 长度为 i 的字符在整个字符串中的个数= len - i
            for (j = 0; j <= len - i; j++) {
                if (allUnique2(str, j, i + j)) {
                    maxSubLen = i;
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }

        System.out.println(maxSubLen);
        return maxSubLen;
    }

    public static boolean allUnique2(String str, int start, int end){
        Set<Character> set = new HashSet<>();
        String subStr = str.substring(start, end);
        for(int k = 0; k < subStr.length(); k++){
            if(set.contains(subStr.charAt(k))){
                return false;
            }
            set.add(subStr.charAt(k));
        }
        return true;
    }

    // 滑动窗口:窗口内的都是已经判断过的没有重复字符的子串，无需重新判断，从而减少判断的次数
    public static int getLengthOfLongestSubstring3(String str) {
        if(str == null && str.length() < 1){
            return 0;
        }

        int len = str.length();
        Set<Character> set = new HashSet<>();
        int maxSubLen = 0, i = 0, j = 0;
        while(i < len && j < len){
            // 扩大[i,j]的范围
            if(!set.contains(str.charAt(j))){
                set.add(str.charAt(j++));
                maxSubLen = Math.max(maxSubLen, j - i);
            }else{
                set.remove(str.charAt(i++));
            }
        }
        System.out.println(maxSubLen);
        return maxSubLen;
    }

    // 优化的滑动窗口
    public static int getLengthOfLongestSubstring4(String str) {
        if (str == null && str.length() < 1) {
            return 0;
        }

        int len = str.length(), maxSubLen = 0;
        Map<Character,Integer> map = new HashMap<>();

        for(int j = 0, i = 0; j < len; j++){
            if(map.containsKey(str.charAt(j))){
                // 比较i和j'谁更靠后

                i = Math.max(map.get(str.charAt(j)), i);
            }
            maxSubLen = Math.max(maxSubLen, j - i + 1);
            map.put(str.charAt(j), j + 1);
        }
        System.out.println(maxSubLen);
        return maxSubLen;
    }
}
