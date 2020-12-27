package LeetCode;

import java.util.Stack;

/**
 * @Author LT
 * @Date 2020/9/11 18:16
 * @Version 1.0
 * @Description
 */
//括号匹配
public class L20 {
    public static void main(String[] args) {
        System.out.println(isValid("([])"));
    }

    public static boolean isValid1(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty()){
                stack.push(chars[i]);////如果一开始就是有右括号
            }else if (chars[i] == '(' ||chars[i] == '{'||chars[i] == '['){
                stack.push(chars[i]);
            }else if (!stack.isEmpty()){
                char temp = stack.peek();
                if (chars[i] == ')' && temp == '('){
                    stack.pop();
                }else if (chars[i] == ']' && temp == '[') {
                    stack.pop();
                }else if (chars[i] == '}' && temp == '{'){
                    stack.pop();
                }else {
                    stack.push(chars[i]);
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c: chars){
            if (c == '(')
                stack.push(')');
            else if(c=='[')
                stack.push(']');
            else if(c=='{')
                stack.push('}');
            else if (stack.isEmpty() || c != stack.pop())//pop
                return false;
        }
        return stack.isEmpty();
    }
}
