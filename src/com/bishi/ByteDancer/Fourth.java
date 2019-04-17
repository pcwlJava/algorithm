package com.bishi.ByteDancer;

import java.util.Scanner;

/**
 * @author pengcheng
 * @date 2019/4/14 - 10:55
 * @content:
 */
public class Fourth {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sc.nextLine();

        int[][] cost = new int[n][n];
        for(int i = 0; i < n; i++){
            String str = sc.nextLine();
            String[] str1 = str.split(" ");
            for(int j = 0; j < n; j++){
                cost[i][j] = Integer.valueOf(str1[j]);
            }
        }

        int[] minCost = new int[n - 1];
        int res = 0;


        for(int i = 0; i < n; i++){
            int temp = 100000;
            for(int j = 0; j < n - 1; j++){
                if(!(cost[i][j + 1] == 0)){
                    if(cost[i][j + 1] < temp){
                        temp = cost[i][j + 1];
                    }
                }
            }
            res += temp;
        }
        System.out.println(res);
    }
}
