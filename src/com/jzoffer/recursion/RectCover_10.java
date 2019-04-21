package com.jzoffer.recursion;

/**
 * @author pengcheng
 * @date 2019/4/18 - 10:39
 * @content:
 */
public class RectCover_10 {

    public int RectCover(int target){
        if(target == 0){
            return 0;
        }
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }

        // 仍然是画出前几个找出规律
        return RectCover(target - 1) + RectCover(target - 2);
    }
}
