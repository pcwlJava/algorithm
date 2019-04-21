package com.jzoffer.queue;

import java.util.Stack;

/**
 * @author pengcheng
 * @date 2019/4/17 - 22:35
 * @content:
 */
public class TwoStackToQueue_5 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node){
        // 每次都是将元素压入stack1中
        stack1.push(node);
    }

    public int pop(){
        if(stack1.isEmpty() && stack2.isEmpty()){
            throw new RuntimeException("Queue is empty!");
        }
        if(stack2.isEmpty()){
            // 如果stack2为空的话，则将stack1中的元素全部压入stack2中
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
