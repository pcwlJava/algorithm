package com.jzoffer.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengcheng
 * @date 2019/4/18 - 21:47
 * @content:
 */
public class PrintMatrix_19 {

    public static ArrayList<Integer> list = new ArrayList<Integer>();
    public static ArrayList<Integer> printMatrix(int[][] matrix){

        if(matrix == null || matrix.length < 1 || matrix[0].length < 1){
            return list;
        }

        // 两个对角的坐标：左上角和右下角
        int lr = 0;    // 上边界
        int lc = 0;    // 左边界
        int rr = matrix.length - 1;     // 下边界
        int rc = matrix[0].length - 1;  // 右边界

        // 左上角的横坐标有一个大于等于右下角的横坐标的时候停止打印
        while (lr <= rr && lc <= rc){
            printMatrix(matrix, lr++, lc++, rr--, rc--);
        }
        return list;
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix, int lr, int lc, int rr, int rc){
        if(lr == rr){
            // 说明最后剩下一行数据了
            for(int i = lc; i <= rc; i++){
                list.add(matrix[lr][i]);
            }
        }else if(lc == rc){
            // 说明最后剩下一列数据了
            for(int i = lr; i <= rr; i++){
                list.add(matrix[i][lc]);
            }
        }else{
            int curC = lc;
            int curR = lr;

            while(curC != rc){
                // 打印上横线
                list.add(matrix[lr][curC]);
                curC++;
            }
            while(curR != rr){
                // 打印右竖线
                list.add(matrix[curR][rc]);
                curR++;
            }
            while(curC != lc){
                // 打印下横线
                list.add(matrix[rr][curC]);
                curC--;
            }
            while(curR != lr){
                // 打印左竖线
                list.add(matrix[curR][lc]);
                curR--;
            }

        }
        return list;
    }

    public static void main(String[] args) {
        printMatrix(new int[][]{{1},{2},{3},{4},{5}});
    }
}
