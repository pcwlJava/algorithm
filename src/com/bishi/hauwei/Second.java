package com.bishi.hauwei;

import java.util.Scanner;

public class Second {

    private static int index = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        if(str == null && str.length() < 1){
            System.out.println("");
        }

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '{' || str.charAt(i) == '['){
                str.replace('(',str.charAt(i));
            }else if(str.charAt(i) == '}' || str.charAt(i) == ']'){
                str.replace(')',str.charAt(i));
            }
        }

        int len = str.length();
        char arr[] = str.toCharArray();
        decode(arr,len);
    }

    public static  String decode(char[] arr, int len){
        StringBuffer sb = new StringBuffer();
        int n = 0;
        while(index < 0){
            if(arr[index] >= '0' && arr[index] <= '9'){
                n = n * 10 + Integer.parseInt(String.valueOf(index));
                index++;
            }else if(arr[index] == '('){
                index++;
                if(n > 0){
                    String str  = decode(arr, len);
                    for(int i = 0; i < n; i++){
                        sb.append(str);
                    }
                    n = 0;
                }
            }else if(arr[index] == ')'){
                index++;
                return sb.toString();
            }else{
                sb.append(arr[index]);
                index++;
            }
        }
        System.out.print(sb.toString());
        return sb.toString();
    }
}