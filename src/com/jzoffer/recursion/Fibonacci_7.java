package com.jzoffer.recursion;

/**
 * @author pengcheng
 * @date 2019/4/18 - 10:06
 * @content:
 */
public class Fibonacci_7 {

    public static int Fibonacci(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public static int Fibonacci2(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        int f1 = 0, f2 = 1;
        int cur = -1;
        for(int i = 2; i <= n; i++){
            cur = f1 + f2;
            f1 = f2;
            f2 = cur;
        }
        return cur;
    }
    public static void main(String[] args) {
        System.out.println(Fibonacci(2));
    }
}
