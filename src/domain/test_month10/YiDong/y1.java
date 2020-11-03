package domain.test_month10.YiDong;

import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/10/29 19:16
 * @Version 1.0
 * @Description
 */
public class y1 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        fun(n);
    }

    private static void fun(int n) {
        int total = 1;
        while (n != 1){
            total = total * 2 + 2;
            n--;
        }
        System.out.println("total="+total);
    }
}
