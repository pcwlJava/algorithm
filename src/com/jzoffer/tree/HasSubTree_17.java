package com.jzoffer.tree;

/**
 * @author pengcheng
 * @date 2019/4/18 - 20:31
 * @content:
 */
public class HasSubTree_17 {

    // 判断以root2为根节点的树是否为以root1为根节点树的子树
    public boolean HasSubTree(TreeNode root1, TreeNode root2){
        boolean result = false;
        // 递归终止条件
        if(root1 != null && root2 != null){
            // 如果在tree1中找到了root2，则开始以该节点为根节点和tree2进行比较
            if(root1.val == root2.val){
                result = doesTree1HasTree2(root1, root2);
            }
            // 如果找不到，那么就去root1的左儿子为根节点时的子树中去找
            if(!result){
                result = HasSubTree(root1.left, root2);
            }

            // 如果还是找不到，那么就去root1的右儿子为根节点时的子树中去找
            if(!result){
                result = HasSubTree(root1.right, root2);
            }
        }
        return result;
    }

    public boolean doesTree1HasTree2(TreeNode node1, TreeNode node2){
        // 如果tree2已经遍历完了，并且都能对的上的话，则返回true
        if(node2 == null){
            return true;
        }

        // 如果tree1已经遍历完了，tree2还没有遍历完，则返回false
        if(node1 == null){
            return false;
        }

        // 如果其中有一个点没有对上，则返回false
        if(node1.val != node2.val){
            return false;
        }

        return doesTree1HasTree2(node1.left, node2.left) && doesTree1HasTree2(node1.right, node2.right);
    }
}
