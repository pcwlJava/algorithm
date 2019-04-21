package com.dailypractice.scanner;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author pengcheng
 * @date 2019/4/17 - 19:43
 * @content:
 */
public class NextTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 一个 while 就是一个测试用例
        while(sc.hasNext()){
            int n = sc.nextInt();   // 该测试用例后序接收多少参数

            // 如果没有该行，则执行第一个sc.nextLine()命令时的返回值是int n = sc.nextInt()的值
            sc.nextLine();
            HashSet<String> set = new HashSet<String>();

            for(int i = 0; i < n; i++){
                String line = sc.nextLine();
                String[] arr = line.split(" ");
                for(int j = 0; j < arr.length; j++){
                    set.add(arr[j]);
                }
            }
            System.out.println("sum：" + set.size());
        }
    }
}



