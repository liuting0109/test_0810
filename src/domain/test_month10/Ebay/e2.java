package domain.test_month10.Ebay;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author LT
 * @Date 2020/10/16 19:40
 * @Version 1.0
 * @Description
 */
//括号匹配
public class e2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T -- > 0){
            String s = sc.next();
            piPei(s);
        }
    }
    public static void piPei(String s){
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (stack.isEmpty()){
                stack.push(c);
            }else if (c == '{' || c == '[' || c == '(' ){
                stack.push(c);
            }else{
                char temp = stack.peek();
                if ((temp == '{' && c == '}')|| (temp == '[' && c == ']') || (temp == '(' && c == ')')){
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
        }
        if (stack.size() > 0)
            System.out.println("No");
        else {
            System.out.println("Yes");
        }
    }
}
