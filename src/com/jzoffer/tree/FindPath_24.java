package com.jzoffer.tree;

import java.util.ArrayList;

/**
 * @author pengcheng
 * @date 2019/4/20 - 9:03
 * @content:
 */
public class FindPath_24 {

    ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
        if(root == null){
            return listAll;
        }

        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            // 这里必须重新new一个ArrayList，不然所有的list都会指向同一个ArrayList
            // 添加一条路径
            listAll.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        // 深度遍历完最后一个元素要回退
        list.remove(list.size() - 1);
        return listAll;
    }
}
