package LeetCode1;

import java.util.LinkedList;

public class L394 {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int num = 0;
        LinkedList<Integer> stack_num = new LinkedList<>();
        LinkedList<String> stack_res= new LinkedList<>();
        for (Character c: s.toCharArray()){
            if (c == '['){
                stack_num.addLast(num);
                stack_res.addLast(res.toString());
                num = 0;
                res = new StringBuilder();
            }else if (c == ']'){
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_num.removeLast();
                for(int i = 0; i < cur_multi; i++) tmp.append(res);
                res = new StringBuilder(stack_res.removeLast() + tmp);
            }
            else if(c >= '0' && c <= '9')//处理二位数字
                num = num * 10 + Integer.parseInt(c + "");
            else res.append(c);
        }
        return res.toString();
    }
}
