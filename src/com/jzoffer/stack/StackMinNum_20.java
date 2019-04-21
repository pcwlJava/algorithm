package com.jzoffer.stack;

import java.util.Stack;

/**
 * @author pengcheng
 * @date 2019/4/18 - 22:53
 * @content: 要求时间复杂度为O(1)，所以肯定需要借助额外的栈空间
 */
public class StackMinNum_20 {

    Stack<Integer> dataStack = new Stack<Integer>();    // 数据栈
    Stack<Integer> minStack = new Stack<Integer>();     // 辅助栈

    public void push(int node){
        dataStack.push(node);
        if(minStack.isEmpty() || node < minStack.peek()){
            minStack.push(node);   // 压进辅助栈
        }else{
            // 如果要压进数据栈的元素比当前辅助栈中的最小值大，则将辅助栈中的最小值再压一次
            minStack.push(minStack.peek());
        }
    }

    public void pop(){
        dataStack.pop();
        minStack.pop();
    }

    public int top(){
        return dataStack.peek();
    }

    public int min(){
        return minStack.peek();
    }
}
