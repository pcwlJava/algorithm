package com.zuoshen.foundation.class4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pengcheng
 * @date 2019/3/28 - 14:20
 * @content: 按层来序列化和反序列化二叉树
 */
public class SerializeAndReconstructByLevel {

    public static class Node{
        private int val;
        private Node left;
        private Node right;

        public Node(int val){
            this.val = val;
        }
    }

    // 按层序列化
    public String serializeByLevel(Node head){
        if(head == null){
            return "#_";
        }

        String res = head.val + "_";
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(head);
        while(!queue.isEmpty()){
            // 中
            head = queue.poll();
            // 左
            if(head.left != null){
                res += head.left.val + "_";
                queue.offer(head.left);
            }else{
                res += "#_";
            }
            // 右
            if(head.right != null){
                res += head.right.val + "_";
                queue.offer(head.right);
            }else{
                res += "#_";
            }
        }
        return res;
    }

    // 按层反序列化
    public Node recornByLevelString(String levelStr){
        String[] values = levelStr.split("_");
        int index = 0;
        Node head = generateNodeByString(values[index++]);
        Queue<Node> queue = new LinkedList<Node>();
        if(head != null){
            queue.offer(head);           // 中
        }
        Node node = null;
        while(!queue.isEmpty()){
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if(node.left != null){
                queue.offer(node.left);   // 左
            }
            if(node.right != null){
                queue.offer(node.right);  // 右
            }
        }
        return head;
    }

    // 根据字符串构建一个节点
    public Node generateNodeByString(String str){
        if(str.equals("#")){
            return null;
        }
        return new Node(Integer.valueOf(str));
    }
}
