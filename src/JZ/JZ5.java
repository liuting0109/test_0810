package JZ;

import java.util.Stack;

public class JZ5 {
    /**
     * 用两个栈来实现一个队列，完成队列的Push和Pop操作。
     * 队列中的元素为int类型。
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();


    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()){//if (!stack2.isEmpty()) 如果为空，则从stack1中取值
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();//如果stack2不为空，直接pop，因为中间如果有新值加入的话，会影响pop的顺序
    }

}
