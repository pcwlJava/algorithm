package com.jzoffer.tree;

/**
 * @author pengcheng
 * @date 2019/4/19 - 13:25
 * @content:
 */
public class VerifySequenceOfBST_23 {

    public boolean VerifySequenceOfBST(int[] sequence){
        if(sequence.length == 0){
            return false;
        }

        if(sequence.length == 1){
            return true;
        }

        return judge(sequence, 0, sequence.length - 1);
    }

    public boolean judge(int[] a, int start, int end){
        if(start >= end){
            return true;
        }

        int i = start;
        while(a[i] < a[end]){
            ++i;
        }
        for(int j = i; j < end; j++){
            if(a[j] < a[end]){
                return false;
            }
        }
        return judge(a, start, i - 1) && judge(a, i, end - 1);
    }
}
