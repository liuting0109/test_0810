package domain.test_month9.Gbit;

import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/25 21:16
 * @Version 1.0
 * @Description
 */
//统计一个数有多少个因子

public class g2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int res = yinzi(num);
        System.out.println(res);
    }

    static int count = 0;
    private static int yinzi(int num) {
        //int count = 0;

        int n = 2;
        while (n < num && num % n != 0){
            n++;
        }
        if (n < num){
            //System.out.println(n +" ");
            count++;
            yinzi(num / n);
        }else {
            count++;
            //System.out.println(n);
        }
        return count;
    }
}
