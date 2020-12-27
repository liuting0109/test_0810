package LeetCode;

import java.util.LinkedList;

public class L394 {
    /*
     构建辅助栈 stack， 遍历字符串 s 中每个字符 c；
    当 c 为数字时，将数字字符转化为数字 multi，用于后续倍数计算；
    当 c 为字母时，在 res 尾部添加 c；
    当 c 为 [ 时，将当前 multi 和 res 入栈，并分别置空置 00：
    记录此 [ 前的临时结果 res 至栈，用于发现对应 ] 后的拼接操作；
    记录此 [ 前的倍数 multi 至栈，用于发现对应 ] 后，获取 multi × [...] 字符串。
    进入到新 [ 后，res 和 multi 重新记录。
    当 c 为 ] 时，stack 出栈，拼接字符串 res = last_res + cur_multi * res，其中:
    last_res是上个 [ 到当前 [ 的字符串，例如 "3[a2[c]]" 中的 a；
    cur_multi是当前 [ 到 ] 内字符串的重复倍数，例如 "3[a2[c]]" 中的 2。
    返回字符串 res。
    复杂度分析：

    时间复杂度 O(N)O(N)，一次遍历 s；
    空间复杂度 O(N)O(N)，辅助栈在极端情况下需要线性空间，例如 2[2[2[a]]]。

     */
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
    public static String decodeString(String s) {
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
