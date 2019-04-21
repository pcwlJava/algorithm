package com.bishi.hauwei;

import java.util.Scanner;
import java.util.Stack;

public class Second {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        if(str == null || str.length() < 1){
            System.out.println("");
        }
        // 将所有的括号都替换成（）形式
        String newStr = replaceStr(str);
        // 解码字符串
        String resString = decodeString(newStr);
        // 逆序字符串
        StringBuffer sb = new StringBuffer(resString);
        System.out.print(sb.reverse());
    }

    public static String replaceStr(String str){
        str = str.replace('{','(');
        str = str.replace('[','(');
        str = str.replace('}',')');
        str = str.replace(']',')');

        return str;
    }

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
            }else if(ch == '('){
                // 遇到 '[' 时，将之前的字符和数字都压栈，并将其引用设为初始值
                resStack.push(res);
                res = "";
                countStack.push(curNum);
                curNum = 0;
                index++;
            }else if(ch == ')'){
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
}