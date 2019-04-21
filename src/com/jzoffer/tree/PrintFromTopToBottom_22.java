package com.jzoffer.tree;

import java.util.ArrayList;

/**
 * @author pengcheng
 * @date 2019/4/19 - 12:31
 * @content: 用一个辅助的队列实现
 */
public class PrintFromTopToBottom_22 {

    public ArrayList<Integer> printFromTopToBottom(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        if(root == null){
            return list;
        }

        queue.add(root);
        while(queue.size() != 0){
            TreeNode temp = queue.remove(0);
            if(temp.left != null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
            list.add(temp.val);
        }
        return list;
    }
}
