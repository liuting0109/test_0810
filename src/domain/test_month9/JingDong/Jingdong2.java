package domain.test_month9.JingDong;

import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/17 19:41
 * @Version 1.0
 * @Description
 */
/*
一只虫子掉到枯井里，它每天白天都会向上爬n厘米，但是晚上休息时会下降若干厘米。通过分析发现，第1天晚上虫子会下降n/2厘米，第2天晚上虫子会下降(n/2+n/4)厘米，第3天晚上虫子会下降(n/2+n/4+n/8)厘米，......，以此类推。
如果井的深度为m米，请问这只努力的虫子第几天能够爬出枯井？
输入描述
单组输入。
每组输入数据占1行。
每行输入两个正整数n和m，且50*m<n<100*m。
m≤100，输入数据保证问题有解。
输出描述
输出一个正整数，即虫子第几天爬出枯井。

样例输入
60 1
样例输出
3
 */
public class Jingdong2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int res = fun(n,m * 100);
        System.out.println(res);
        //double aa = (double) 7/2;
       // System.out.println(aa);
    }

    private static int fun(int n, int m) {
        int count = 1;
        if (n >= m)
            return 1;
        double down = (double) n/2;
        int res = 0;
        double sum = n;
        while (sum < m){

            if (sum >= m){
                count++;
                break;
            }
            if (count == 1){

            }else {
                down = down + ((double) n) / Math.pow(2, count);
            }
            count++;
            sum -= down;
            sum += n;
        }

        return count;
    }
}
