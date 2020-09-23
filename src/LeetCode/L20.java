package LeetCode;

import java.util.Stack;

/**
 * @Author LT
 * @Date 2020/9/11 18:16
 * @Version 1.0
 * @Description
 */
public class L20 {
    public boolean isValid1(String s) {//写的不完整
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty()){
                stack.push(chars[i]);//如果一开始就是有右括号
            } else if (chars[i] == '(' ||chars[i] == '{'||chars[i] == '['){
                stack.push(chars[i]);
            }else if (!stack.isEmpty()){
                char temp = stack.peek();
                if (chars[i] == ')' && temp == '('){
                    stack.pop();
                }else if (chars[i] == ']' && temp == '[') {
                    stack.pop();
                }else if (chars[i] == '}' && temp == '{'){
                    stack.pop();
                }
                else {
                    stack.push(chars[i]);
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid(String s) {//写的不完整
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' ||chars[i] == '{'||chars[i] == '['){
                stack.push(chars[i]);
            }else {
                char temp = stack.peek();
                if (chars[i] == ')' && temp == '('){
                    stack.pop();
                }else if (chars[i] == ']' && temp == '[') {
                    stack.pop();
                }else if (chars[i] == '}' && temp == '{'){
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
