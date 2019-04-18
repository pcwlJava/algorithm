package com.jzoffer.linkedList;

/**
 * @author pengcheng
 * @date 2019/4/18 - 20:02
 * @content:
 */
public class MergeTwoLinkedList_16 {

    public ListNode Merge(ListNode list1, ListNode list2){
        if(list1 == null && list2 == null){
            return null;
        }
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        ListNode mergeHead = null;
        ListNode current = null;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
               if(mergeHead == null){
                   mergeHead = current = list1;
               }else{
                   current.next = list1;
                   current = current.next;
               }
               list1 = list1.next;   // 指针向后移动一位
            }else{
                if(mergeHead == null){
                    mergeHead = current = list2;
                }else{
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
        }

        if(list1 == null){
            current.next = list2;
        }else{
            current.next = list1;
        }
        return mergeHead;
    }

    // 递归实现
    public ListNode Merge2(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        // 谁的头节点小，就用谁的头结点当合并后的头结点，直接在该链表后面开始合并
        if(list1.val <= list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge(list1, list2.next);
            return  list2;
        }
    }
}
