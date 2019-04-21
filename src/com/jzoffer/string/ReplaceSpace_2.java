package com.jzoffer.string;

/**
 * @author pengcheng
 * @date 2019/4/17 - 21:21
 * @content:
 */
public class ReplaceSpace_2 {

    public static String replaceSpace(StringBuffer str){
        if(str == null || str.length() < 1){
            return "";
        }

        String res = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                res = res + "%20";
            }else{
                res = res + str.charAt(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str1 = "We Are Happy";
        StringBuffer str = new StringBuffer(str1);
        System.out.println(replaceSpace(str));
    }
}
