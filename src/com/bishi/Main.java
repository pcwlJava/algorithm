package com.bishi;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static int fb(int m){

        int[] res = new int[3];

        if(m == 1){
            return 2;
        }else if(m == 2){
            return 3;
        }else if(m == 3){
            return 4;
        }else{
            return fb(m - 2) + fb(m - 3);
        }
    }

    // m为猪的编号
    public static int getYear(int m){

        int i = 0;

        if(m == 1 || m == 2){
            return 1;
        }else if (m == 3){
            return 2;
        }else if(m == 4){
            return 3;
        }else{
            // 第i年猪的数量
            int num = getYear(i - 1) + getYear(i - 3);
            i++;
            if(m <= num){
                return i;
            }
            return i;
        }
    }

    public static int getK(int k, int m){

        if(m <= 0){

        }

        int j = 2;
        Stack stack = new Stack();
        if(fb(m) > j){

            stack.add(j);


        }
        return 0;
    }

    public static String calculate(int m, int k) {
        if(m == 0){
            return null;
        }

        int[] res = new int[3];
        res[0] = fb(m);

        int year = getYear(res[0]);
        res[1] = year;

        // res[2] 为翻转编号第k大的猪
        res[2] = getK(k,m);

        return res.toString();

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        int m = Integer.valueOf(line[0]);
        int k = Integer.valueOf(line[1]);
        System.out.println(calculate(m, k));

    }
}
