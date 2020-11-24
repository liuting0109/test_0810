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
                min = node;
            }
            stack.push(node);
        }
    }
/*
在看到这道题目的时候第一反应是要用一个最小值来保留当前栈中最小值，
但是也能够很快地意识到比较麻烦的地方在于pop的时候怎么更新min值，
看了别人的题解之后都是使用了另外一个栈来保持在入栈过程中曾经做过最小值的值，
pop的时候判断两个栈顶元素是否一致，一致的话都要pop，
在这种情况下取最小值需要从保存最小值的栈顶元素取值
另外一点是这道题目也顺便联系java中Stack的常用的方法empty(); push(); pop();peek()；
比较坑爹的时元素需要定义为static的并且要手动初始化，不然list会被初始化为null
我自己的想法是不希望用另外一个栈，
那么为了实现这一目的，在栈中需要保留冗余的曾经的最小值，
这样能够比较方便到找到当前的此小值，具体见下面的代码
 */
    public void pop() {//什么意思？？？？
        //增加最后一个元素以及栈为空时候的检测
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

    //应用一个辅助栈，压的时候，如果A栈的压入比B栈压入大，B栈不压，，，，小于等于，AB栈同时压入，出栈，如果，AB栈顶元素不等，A出，B不出。
    class sloution{
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> min = new Stack<>();
        public void push(int node) {
            stack1.push(node);
            if (min.isEmpty())
                min.push(node);
            else if (node <= min.peek()){
                min.push(node);
            }
        }

        public void pop() {
            if (stack1.peek() == min.peek()){
                min.pop();
            }
            stack1.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int min() {
            return min.peek();
        }
    }
}
