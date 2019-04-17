package com.leetcode.string;

import java.util.Stack;

/**
 * @author pengcheng
 * @date 2019/4/13 - 16:28
 * @content:
 */
public class DecodeString_394 {

    public static String decodeString(String str){
        String res = "";

        // 记录'['之前的数字
        Stack<Integer> countStack = new Stack<>();
        // 记录'['之前的字符串运算结果
        Stack<String> resStack = new Stack<>();

        int index = 0;
        int curNum = 0;

        while(index < str.length()){
            char ch = str.charAt(index);
            if(Character.isDigit(ch)){
                // 如果当前字符是数字的时候，计算出来括号中的数字
                while(Character.isDigit(str.charAt(index))){
                    curNum = 10 * curNum + (str.charAt(index++) - '0');
                }
            }else if(ch == '['){
                // 遇到 '[' 时，将之前的字符和数字都压栈，并将其引用设为初始值
                resStack.push(res);
                res = "";
                countStack.push(curNum);
                curNum = 0;
                index++;
            }else if(ch == ']'){
                // 遇到 ']' 就将两个栈里面的内容弹出，拼接到 res 中
                StringBuilder temp = new StringBuilder(resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                index++;
            }else{
                // index 位置处的字符为字母，直接添加到res中，index++
                res += str.charAt(index++);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        decodeString("abc4[A]");
    }
}
