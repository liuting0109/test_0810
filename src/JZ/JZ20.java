package JZ;

import java.util.Stack;

/*
定义栈的数据结构，请在该类型中
实现一个能够得到栈中所含最小元素的min函数
（时间复杂度应为O（1））。
 */
public class JZ20 {
    Stack<Integer> stack = new Stack<>();
    Integer min = Integer.MIN_VALUE;
    public void push(int node) {
        if (stack.isEmpty()){
            min = node;
            stack.push(min);
        }else {
            if (node <= min){
                stack.push(min);//在push更小的值时需要保留在此值之前的最小值
                min = node;//pop会把栈顶的值删除。
            }
            stack.push(node);
        }
    }

    public void pop() {
        if (stack.size() ==0)
            return;
        if (min == stack.peek()){
            if (stack.size() > 1){
                stack.pop();//pop会把栈顶的值删除。
                min = stack.peek();
            }else {
                min = Integer.MAX_VALUE;
            }
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }
}
