package domain.test;

import java.util.Scanner;

/**求旅行次数 beijing到beijing算一次 fuzhou到fuzhou算一次 共计2次
 * ac 100% ； package 不要导入答题框内
 * 字符串判断是否相等 用equals， not == !!!
 */
public class MeiTuan2 {
    //static int count  = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] ticket = new String[n*2];
        for (int j = 0; j < 2*n; j++) {
            ticket[j] = sc.next();
        }
        /*for (String s:ticket)
            System.out.println(s+s.length());*/
        System.out.println(fun(ticket));
        /*String[] temp ={"beijing","nanjing",
                "nanjing" ,"guangzhou" ,
                "guangzhou", "shanghai" ,
                "shanghai ","beijing",
                "fuzho","beijing" ,
                "beijing", "fuzhou"};
        System.out.println(fun(temp));*/
    }
    public static int fun(String[] str){
        int count = 0;
        String temp = str[0];
        for (int i = 1; i < str.length - 1; i++) {
            if (str[i].equals(temp)){
                count++;
                temp = str[i+1];
                i++;
            }
        }
        return count+1;
    }
}
