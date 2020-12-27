package LeetCode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Author LT
 * @Date 2020/9/10 10:34
 * @Version 1.0
 * @Description
 */
public class L32 {
    public static void main(String[] args) {

        System.out.println(longestValidParentheses(")()())"));
    }
    public static int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        char[] chars = s.toCharArray();
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            if (chars[i] == '('){
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()) {//遇到前面是有括号的， 更改坐标点
                    stack.push(i);
                }else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
