package com.jzoffer.linkedList;

/**
 * @author pengcheng
 * @date 2019/4/18 - 18:28
 * @content:
 */
public class FindKthToTail_14 {

    public static ListNode FindKthToTail(ListNode head, int k){
        if(head == null || k < 1){
            return null;
        }

        ListNode node = head;
        int size = 0;
        while (node != null){
            size++;
            node = node.next;
        }

        // 倒数第k个，其实就是正数第n-k+1个
        for(int i = 1; i <= size; i++){
            if(i == size - k + 1){
                return head;
            }
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        FindKthToTail(node1,1);
    }
}
