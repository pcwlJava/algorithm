package com.jzoffer.linkedList;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author pengcheng
 * @date 2019/4/17 - 21:36
 * @content:
 */
public class printListFromTailToHead_3 {

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(listNode == null){
            return list;
        }
        Stack<Integer> stack = new Stack<Integer>();

        while(listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;  // 遍历
        }

        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(67);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(24);
        ListNode node4 = new ListNode(58);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        printListFromTailToHead(node1);
    }
}
