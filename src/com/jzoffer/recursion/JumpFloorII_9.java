package com.jzoffer.recursion;

/**
 * @author pengcheng
 * @date 2019/4/18 - 10:25
 * @content:
 */
public class JumpFloorII_9 {

    public int JumpFloorII(int target){
        if(target == 0){
            return 0;
        }

        if(target == 1){
            return 1;
        }

        // 写出前几个台阶的走法，就可以找到规律了
        return 2 * JumpFloorII(target - 1);
    }
}
