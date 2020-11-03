package domain.test_month9.QuNaEr;

import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/23 18:57
 * @Version 1.0
 * @Description
 */
public class q1 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        n = Math.min(n, m - n);
        fun(m,n);
    }
    public static void fun(int m, int n){
        double a = 1;
        for (int i = 1; i <= m; i++) {
            a *= i;
        }
        double b = 1;
        for (int i = 1; i <= n; i++) {
            b*= i;
        }
        double c = 1;
        for (int i = 1; i <= m - n; i++) {
            c *= i;
        }
        double res = a/(b*c);
        System.out.println((int) res);
    }
}
