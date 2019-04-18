package com.jzoffer.recursion;

/**
 * @author pengcheng
 * @date 2019/4/18 - 10:17
 * @content:
 */
public class JumpFloor_8 {

    public static int JumpFloor(int target){
        if(target == 0){
            return 0;
        }
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }

        System.out.println(JumpFloor(target - 1) + JumpFloor(target - 2));
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    public static int JumpFloor2(int target){
        if(target == 0){
            return 0;
        }
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }

        int f1 = 1, f2 = 2, cur = 0;
        for(int i = 3; i <= target; i++){
            cur = f1 + f2;
            f1 = f2;
            f2 = cur;
        }
        return cur;
    }
    public static void main(String[] args) {
        JumpFloor(4);
    }
}
