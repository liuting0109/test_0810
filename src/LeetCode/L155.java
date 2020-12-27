package LeetCode;

import java.util.Stack;

/**
 * @Author LT
 * @Date 2020/12/25 17:28
 * @Version 1.0
 * @Description
 */
public class L155 {
    Stack<Integer> stack;
    public void MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(x);
            stack.push(x);
        }else {
            int temp = stack.peek();
            stack.push(x);
            if (temp < x){
                stack.push(temp);
            }else {
                stack.push(x);
            }
        }
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        return stack.get(stack.size() - 2);
    }

    public int getMin() {
        return stack.peek();
    }
}
