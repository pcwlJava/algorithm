package com.dailypractice.string;

/**
 * @author pengcheng
 * @date 2019/4/13 - 11:36
 * @content:
 */
public class 字符串子序列 {

    public static void printAllSubString(String str){
        if(str == null){
            return;
        }

        char[] chars = str.toCharArray();
        if(chars.length > 0){
            String pre = new String("");   // pre：用于表示从0到i-1位置上形成的结果
            printAllSubString(0, pre, chars);
        }else{
            System.out.println("");     // 输入空字符串也会打印空
        }
    }

    public static void printAllSubString(int i, String pre, char[] chars){
        // 迭代终止条件
        if(i == chars.length){
            // 说明已经到最后一个字符了，所有的选择都已经做完了，应该返回了
            System.out.println(pre);
            return;
        }

        // 如果没有到最后一个字符，那么当前字符有两种选择：选择要 和 选择不要
        printAllSubString(i + 1, pre, chars);  // 不要当前字符
        printAllSubString(i + 1, pre + String.valueOf(chars[i]), chars);   // 要当前字符
    }

    // 测试
    public static void main(String[] args) {
        printAllSubString("abc");
    }
}
