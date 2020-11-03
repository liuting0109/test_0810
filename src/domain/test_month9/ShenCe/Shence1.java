package domain.test_month9.ShenCe;

import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/14 21:22
 * @Version 1.0
 * @Description
 */
public class Shence1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String res = fun1(n);
        System.out.println(res);
    }

    private static String  fun1(int n) {

        String res = "True";

        if (n <= 1){
            res = "False";
            return res;
        }
        while (n  != 0){
            if (n == 2)
                break;
            if (n % 2 == 0){

            }else {
                res = "False";
                break;
            }
             n /=2;
        }
        return res;
    }
}
