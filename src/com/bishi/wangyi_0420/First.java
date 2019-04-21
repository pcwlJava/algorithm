package com.bishi.wangyi_0420;

import java.util.Scanner;

/**
 * @author pengcheng
 * @date 2019/4/20 - 9:37
 * @content:
 */
public class First {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();

        while(sc.hasNextLine()){
            int N = sc.nextInt();     // N 行
            int M = sc.nextInt();     // M 列

            int X = sc.nextInt();     // X 行
            int Y = sc.nextInt();     // Y 列
            int W = sc.nextInt();     // W 运动方向
            int T = sc.nextInt();     // T 离开时间

            int C = 0;
            // 左上
            if(W == 0){
                while(T > 0){
                    while(!(X == 0 || Y == 0)){
                        X--;
                        Y--;
                        T--;
                    }
                    C++;
                }
            }

            // 右上
            if(W == 1){
                while(!(X == 0 || Y == M) && T > 0){
                    X--;
                    Y++;
                    T--;
                }
                C++;
            }

            // 右下
            if(W == 2){
                while(!(X == N || Y == M) && T > 0){
                    X++;
                    Y++;
                    T--;
                }
                C++;
            }

            // 左下
            if(W == 3){
                while(!(X == N || Y == 0) && T > 0){
                    X++;
                    Y--;
                    T--;
                }
                C++;
            }
        }

    }

}
