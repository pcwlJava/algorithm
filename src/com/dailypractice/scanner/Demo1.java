package com.dailypractice.scanner;

import java.util.Scanner;

/**
 * @author pengcheng
 * @date 2019/4/10 - 18:35
 * @content:
 */
public class Demo1 {

    public static void main(String[] args) {

        //创建Scanner对象
        //System.in表示标准化输出，也就是键盘输出
        Scanner sc = new Scanner(System.in);

        //利用hasNextXXX()判断是否还有下一输入项
        while(sc.hasNext()){
            //利用nextXXX()方法输出内容
            String str = sc.next();
            System.out.println(str);
        }
    }

    public void getInput(){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        scanner.nextLine();

        String[] strings = new String[n];

        for(int i = 0 ; i < n ; i ++) {
            String s = scanner.nextLine();
            strings[i] = s;
        }
    }

}


