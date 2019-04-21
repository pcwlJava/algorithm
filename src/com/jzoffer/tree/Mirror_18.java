package com.jzoffer.tree;

/**
 * @author pengcheng
 * @date 2019/4/18 - 21:39
 * @content: 二叉树的镜像
 */
public class Mirror_18 {

    public void Mirror(TreeNode root){
        if(root == null){
            return;
        }

        // 有一个不等于null就行
        if(root.left != null || root.right != null){
            // 交换左右子节点
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
        }

        if(root.left != null){
            // 递归左子树
            Mirror(root.left);
        }
        if(root.right != null){
            // 递归右子树
            Mirror(root.right);
        }
    }
}
