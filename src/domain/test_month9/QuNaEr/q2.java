package domain.test_month9.QuNaEr;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/23 18:58
 * @Version 1.0
 * @Description
 */
/*
每周二是去哪儿网集体过需求Final Review的时候，针对机票的报价排序，运营总监小天和产品总监老冯产生了一些不同意见，小天认为报价顺序应该是按照 a、f、d、e、z的顺序来做报价列表排序，老冯认为应该按照f、a、e、d、z的顺序来做列表排序，两人争执不下，技术总监这时站了出来，认为他们其实大多数意见是一致的，只有少数不一致，可以先把意见一致的排序作为一期做上去，有争议的后续再来做，那么如果一期本着把小天和老冯报价顺序意见一致的报价先做上去，那么最多可以做上去多少个报价的排序。
输入描述
7(多少个报价)
a b c d e f g
b d a c f g e
输出描述
4(b d f g)
样例输入
7
a b c d e f g
b d a c f g e
样例输出
4
 */
public class q2 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        //String[] st1 = sc.next().trim().split(" ");
        //String[] st2 = sc.next().trim().split(" ");
        String temp = sc.nextLine();
        String st1 = sc.nextLine();
        String st2 = sc.nextLine();
        int res = fun(st1, st2, n);
        System.out.println(res);
    }
/*
7
a b c d e f g
b d a c f g e
 */
    private static int fun(String st1, String st2, int n) {
        String[] str1 = st1.split(" ");
        String[] str2 = st2.split(" ");
        if (n < 2)
            return n;
        int[] dp = new int[n];

        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            String ss = str2[i];
            for (int j = 0; j < n; j++) {
                if(str1[j].equals(ss)) {
                    temp[i] = j;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            //System.out.println(temp[i]);
        }

        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (temp[j] < temp[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
