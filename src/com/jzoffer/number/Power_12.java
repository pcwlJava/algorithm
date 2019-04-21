package com.jzoffer.number;

/**
 * @author pengcheng
 * @date 2019/4/18 - 11:01
 * @content:
 */
public class Power_12 {

    public static double Power(double base, int exponent){
        if(base == 0){
            return 0;
        }

        if(exponent == 0){
            return 1;
        }

        double res = 1;

        if(exponent > 0){
            for(int i = 0; i < exponent; i++){
                res = res * base;
            }
        }else{
            for(int i = 0; i < Math.abs(exponent); i++){
                res = res * (1 /  base);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Power(-2,4));
    }
}
