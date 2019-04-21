package com.jzoffer.number;

/**
 * @author pengcheng
 * @date 2019/4/18 - 10:45
 * @content:
 */
public class NumOF1_11 {

    public static int NumberOf1(int n){
        if(n == 0){
            return 0;
        }

        String bn = Integer.toBinaryString(n);
        int res = 0;

        for(int i = 0; i < bn.length(); i++){
            if(bn.charAt(i) == '1'){
                res++;
            }
        }
        return res;
    }

    public static int NumberOf1_2(int n){
        if(n == 0){
            return 0;
        }

        int count = 0;
        while (n != 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(3));
    }
}
