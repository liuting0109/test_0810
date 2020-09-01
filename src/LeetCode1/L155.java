package LeetCode1;

import java.util.Stack;

public class L155 {
    /** initialize your data structure here. */
    private Stack<Integer> stack;
    public void MinStack() {
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(x);
            stack.push(x);
        }else {
            int temp = stack.peek();
            stack.push(x);
            if (temp < x){//小于栈顶元素的值进栈
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
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}
