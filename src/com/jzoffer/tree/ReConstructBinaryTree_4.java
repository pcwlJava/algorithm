package com.jzoffer.tree;

/**
 * @author pengcheng
 * @date 2019/4/17 - 22:07
 * @content:
 */
public class ReConstructBinaryTree_4 {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in){
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn){
        if(startPre > endPre || startIn > endIn){
            return null;
        }

        TreeNode root = new TreeNode(pre[startPre]);

        for(int i = startIn; i <= endIn; i++){
            // 找到根节点在中序遍历中的位置，这样就知道左右子树了
            if(in[i] == pre[startPre]){
                // 需要注意左子树和右子树的边界
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }

}
