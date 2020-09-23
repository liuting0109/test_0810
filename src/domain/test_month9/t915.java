package domain.test_month9;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author LT
 * @Date 2020/9/15 10:42
 * @Version 1.0
 * @Description
 */
//Java实现字符串四则运算（带小数点）,加减乘除运算
public class t915 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.insert(0,1);
        sb.insert(0,2);
        System.out.println(sb);

        Queue<Integer> queue = new LinkedList<>();

    }
    class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val){
            this.val = val;
        }
    }


    public static boolean isOpr(String s){////判断字符是否为操作符
        if (s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
            return true;
        }
        return false;
    }

    //判断操作符优先级
    public static int priority(String s) {
        if (s.equals("+") || s.equals("-"))
            return 1;
        return 2;
    }
    //将栈内单字符粘成字符串
    public static void linkString(Stack<String> stack) {
        if (stack.peek().equals(" #"))
            return;
        StringBuilder number = new StringBuilder();
        while (true){
            String s = stack.peek();
            if (s.equals("#"))
                break;
            number.insert(0,s);
            stack.pop();
        }
        stack.push(number.toString());
        stack.push("#");
        number.delete(0,number.length());
    }

    public static void yunSuan(String str){
        //基于栈的FILO思想，将字符串表达式分为数字栈NumStack和符号栈OprStack，并在数字栈中用#将数字隔开：
        Stack<String> numStack = new Stack<>();
        numStack.push("#");
        Stack<String> oprStack = new Stack<>();
        //引用后缀表达式思想判断运算符优先级进行计算

    }
    //计算运算式
    public static void calculate(Stack<String> numStack, Stack<String> oprStack) {
        double res=0;
        //弹出右操作数上的#并将其转为double计算
        numStack.pop();
        double rightNum = Double.parseDouble(numStack.pop());
        //弹出左操作数上的#并将其转为double计算
        numStack.pop();
        double leftNum = Double.parseDouble(numStack.pop());
        String opr = oprStack.pop();
        switch(opr){
            case "+": res = leftNum + rightNum;break;
            case "-": res = leftNum - rightNum;break;
            case "*": res = leftNum * rightNum;break;
            case "/": res = leftNum / rightNum;break;
            default:break;
        }
        //将计算结果压栈
        numStack.push(String.valueOf(res));
        numStack.push("#");
    }

    public static String stringToRes(String str) {
        //基于栈的FILO思想，将字符串表达式分为数字栈NumStack和符号栈OprStack，并在数字栈中用#将数字隔开：
        Stack<String> numStack = new Stack<String>();
        numStack.push("#");
        //引用后缀表达式思想判断运算符优先级进行计算
        Stack<String> oprStack = new Stack<String>();
        String[] ss = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            ss[i] = str.substring(i, i + 1);
        }

        for (String s : ss) {
            if (isOpr(s)) {
                linkString(numStack);
                if (oprStack.isEmpty()) {
                    oprStack.push(s);
                } else {
                    while (!oprStack.isEmpty() && priority(s) <= priority(oprStack.peek())) {
                        linkString(numStack);
                        calculate(numStack, oprStack);
                    }
                    oprStack.push(s);
                }
            } else {
                numStack.push(s);
            }
        }
        while (!oprStack.isEmpty()) {
            linkString(numStack);
            calculate(numStack, oprStack);
        }
        numStack.pop();
        return numStack.peek();
    }
}
