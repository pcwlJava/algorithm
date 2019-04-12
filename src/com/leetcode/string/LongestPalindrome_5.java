package com.leetcode.string;

import java.util.Scanner;

/**
 * @author pengcheng
 * @date 2019/4/9 - 15:53
 * @content:
 */
public class LongestPalindrome_5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String subStr = getLongestPalindrome4(str);
        System.out.println(subStr);
    }

    // 暴力解法
    public static String getLongestPalindrome1(String str){
        if(str.length() <= 1){
            return str;
        }

        // 前两层循环是求字符串的所有子串
        for(int i = str.length(); i > 0; i--){
            for(int j = 0; j <= str.length() - i; j++){
                // 本次遍历的字符串长度为：i
                String sub = str.substring(j, i + j);
                int count = 0;
                // 检验当前的子串是否为回文串
                for(int k = 0; k < sub.length() / 2; k++){
                    // k是从0开始的，所以是sub.length-k-1
                    if(sub.charAt(k) == sub.charAt(sub.length() - k - 1)){
                        count++;
                    }
                }
                if(count == sub.length() / 2){
                    System.out.println(sub);
                    return sub;
                }
            }
        }
        return "";  // 没有
    }

    // 动态规划
    public static String getLongestPalindrome2(String str){
        if(str == null && str.length() <= 0){
            return "";
        }

        int len = str.length();
        int start = 0;            // 记录字符串起始的位置
        int maxLength = 1;        // 记录回文串的最大长度
        boolean dp[][] = new boolean[str.length()][str.length()];

        // 长度为1和2的子串的初始化
        for(int i = 0; i < len; i++){
            // 初始化所有长度为1的子串
            dp[i][i] = true;
            // 初始化所有长度为2的子串
            if(i < len - 1 && str.charAt(i) == str.charAt(i + 1)){
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // 以字符串长度为1和2的子串为基础，推导长度：3~len 的子串的dp
        for(int strlen = 3; strlen <= len; strlen++){
            // 从头开始，遍历长度为strlen的子串，并判断它们是否为回文串
            for(int i = 0; i <= len - strlen; i++){
                int j = i + strlen - 1;   // 子串结束位置的下标
                if(dp[i + 1][j - 1] && str.charAt(i) == str.charAt(j)){
                    dp[i][j] = true;
                    // 更新最大回文子串长度为当前子串长度，因为子串长度是不断增加的，所以最后一个回文串肯定是最长的
                    maxLength = strlen;
                    start = i;  // 记录回文串开始位置的下标
                }
            }
        }

        if(maxLength > 0){
            return str.substring(start, start + maxLength);
        }
        return "";
    }

    // 中心扩展法
    public static String getLongestPalindrome3(String str){
        if(str == null && str.length() <= 0){
            return "";
        }

        int maxLength = 1;
        int start = 0;

        // 类似于aba这种情况，以i为中心向两边扩展
        for(int i = 0; i < str.length(); i++){
            int j = i - 1;
            int k = i + 1;
            while((j >= 0 && k < str.length()) && str.charAt(j) == str.charAt(k)){
                if(k - j + 1 > maxLength){
                    maxLength = k - j + 1;
                    start = j;
                }
                j--;
                k++;
            }
        }

        // 类似于abba这种情况，以i，i+1为中心向两边扩展
        for(int i = 0; i < str.length(); i++){
            int j = i;
            int k = i + 1;
            while((j >= 0 && k < str.length()) && str.charAt(j) == str.charAt(k)){
                if(k - j + 1 > maxLength){
                    maxLength = k - j + 1;
                    start = j;
                }
                j--;
                k++;
            }
        }
        if(maxLength > 0){
            return str.substring(start, start + maxLength);
        }
        return "";
    }

    // 中心扩展法：精简版
    public static String getLongestPalindrome4(String str){
        if(str == null || str.length() < 1){
            return "";
        }
        int start = 0, end = 0;
        for(int i = 0; i < str.length(); i++){
            int len1 = expandAroundCenter(str, i, i);            // 偶数回文
            int len2 = expandAroundCenter(str, i, i + 1);  // 奇数回文
            int len = Math.max(len1,len2);
            if(len > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return str.substring(start, end + 1);
    }

    public static int expandAroundCenter(String str, int left, int right){
        while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)){
            left--;
            right++;
        }
        // 算的是左右两边的中间的长度
        return right - left - 1;
    }
}
