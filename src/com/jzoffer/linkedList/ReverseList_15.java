package com.jzoffer.linkedList;

/**
 * @author pengcheng
 * @date 2019/4/18 - 19:51
 * @content:
 */
public class ReverseList_15 {

    public ListNode ReverseList(ListNode head){
        if(head == null){
            return null;
        }

        ListNode pre = null;
        ListNode next = null;

        while(head != null){
            // 先用next指针保存head节点的下一个节点的信息
            next = head.next;
            // 将head指针指向它前面的节点
            head.next = pre;
            // 节点推进
            pre = head;
            head = next;
        }
        // 如果head为null的时候，pre就为最后一个节点了，但是链表已经反转完毕，pre就是反转后链表的第一个节点
        return pre;
    }
}
