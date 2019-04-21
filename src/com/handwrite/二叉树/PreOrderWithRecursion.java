package com.handwrite.二叉树;

/**
 * @author pengcheng
 * @date 2019/4/21 - 15:04
 * @content: 二叉树前序遍历的递归实现
 */
public class PreOrderWithRecursion {

    public void preOrder(TreeNode root){
        if(root != null){
            // 中、左、右
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
