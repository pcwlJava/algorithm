package com.jzoffer.stack;

import java.util.Stack;

/**
 * @author pengcheng
 * @date 2019/4/19 - 9:52
 * @content: 就建立一个辅助栈模拟pushA的出栈过程，只不过需要考虑的是元素不是一次性进栈后再出栈，是交替进行的。所以先从pushA压栈时的元素等于popA时的第一个元素时，开始向后比较。只能是PushA当前元素或者之后的元素和popA的当前PopIndex元素相等
 */
public class IsPopOrder_21 {

    public boolean IsPopOrder(int[] pushA, int[] popA){
        if(pushA.length == 0 || popA.length == 0){
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        // 用于标识弹出序列的位置
        int popIndex = 0;
        for(int i = 0; i < pushA.length; i++){
            // 将pushA中的元素压入stack中
            stack.push(pushA[i]);
            // 如果栈不为空，则弹出栈顶元素与弹出序列的当前popIndex指向的元素进行比较
            while(!stack.empty() && stack.peek() == popA[popIndex]){
                stack.pop();  // 弹出
                popIndex++;   // 后移一位
            }
        }
        return stack.empty();
    }
}
