package domain.test;

import java.util.*;

/**
 *输出满足条件的逆序对,1000以内
 * 2178的逆序 8712 = 4*2178则输出
 * ac55% 因为8712也要在输入的n范围内才可以
 */
public class MeiTuan1 {
    static ArrayList<Integer> res = new ArrayList<>();
    static int count = 0;
    public static void main(String[] args) {
        int num = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 2178){
            System.out.println(0);
        }else {
            fun(n);
            System.out.println(count);
            for (Integer i: res){
                System.out.print(i+" ");
                /*if (num % 2== 1)
                    System.out.println();
                num++;*/
            }
            //System.out.println(res);
        }
       // fun(n);
        /*int n = 190;
        System.out.println(reverse(n));*/
        //System.out.println(res);
    }

    public static void fun(int n){
        for (int i = 1; i <= n ;i++){//暴力会超时，只需遍历到n//4+1 就结束
            int rev = reverse(i);
            if (rev == 4*i && 4 * i <= n){//仅 rev == 4*i判断条件不够；
                count++;
                res.add(i);
                res.add(rev);
            }
        }
    }

    public static int reverse(int n){//1100 逆序是11
        String str = Integer.toString(n);
        StringBuffer sb = new StringBuffer();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return Integer.valueOf(sb.toString());
    }
}
