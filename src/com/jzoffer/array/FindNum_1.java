package com.jzoffer.array;

/**
 * @author pengcheng
 * @date 2019/4/17 - 20:55
 * @content:
 */
public class FindNum_1 {

    public static boolean Find(int target, int[][] array){
        if(array == null || array.length < 1){
            return false;
        }
        int row = array.length;
        int col = array[0].length;
        int i = 0, j = col - 1;


        while(i >= 0 && i < row && j >= 0 && j < col){
            int cur = array[i][j];
            // 如果当前值比目标值小的话，则向下找
            if(target > cur){
                i++;
                continue;
            }else if(target < cur){
                // 如果当前值比目标值大的话，则向左找
                j--;
                continue;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(Find(7,array));
    }
}
