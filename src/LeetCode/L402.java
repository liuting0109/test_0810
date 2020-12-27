package LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author LT
 * @Date 2020/12/3 16:53
 * @Version 1.0
 * @Description
 */
public class L402 {
    public static void main(String[] args) {
        String num = "10200";
        System.out.println(removeKdigits(num, 1));
    }
    public static String removeKdigits(String num, int k) {
        int len = num.length();
        if(k >= len) return "0";
        //Stack<Character> stack = new Stack<>();//用队列比较方便，支持双端操作
        Deque<Character> deque = new LinkedList<>();
        char[] chars = num.toCharArray();
        /*while (true){//不好写，麻烦，因为所有数字都需要入一遍栈
            if (stack.isEmpty() && index < len){
                stack.push(chars[index++]);
            }else {
                if (stack.isEmpty())
            }
        }*/
        for (int i = 0; i < len; i++) {
            while (!deque.isEmpty() && deque.peekLast() > chars[i] && k > 0) {
                deque.removeLast();
                k--;
            }
            deque.offer(chars[i]);
        }

        //1234567情况
        for (int i = 0 ; i < k; i++){
            deque.removeLast();
        }

        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()){
            char digit = deque.pollFirst();
            //去掉前导0
            if (leadingZero == true && digit == '0'){
                continue;
            }
            leadingZero = false;
            sb.append(digit);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
