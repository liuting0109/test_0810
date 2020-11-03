package domain.test_month10.Ebay;

import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/10/16 19:40
 * @Version 1.0
 * @Description
 */
/*
有一个长度为n的数列，在初始状态下，数列每个位置上的数字都是0。现在需要对这个数列进行m次操作，每次操作时我们可以将数列的某一个区间中的全部数字都加上一个特定的数字。请输出m次操作后最终的数列。
输入描述
单组输入。
第1行输入两个正整数n和m，分别表示数列的长度和操作的次数，两个数字之间用空格隔开。
接下来m行，每一行包含三个正整数a、b和c，表示操作区间[a, b]（闭区间，包括a和b）和需要增加的特定数字c，三个数字之间用空格隔开。
（n<=100000,m<=100000,c<=100000）
输出描述
输出m次操作后最终的数列。
样例输入
5 2
1 3 1
2 5 2
样例输出
1 3 3 2 2
 */
public class e1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[] res = fun(n, arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }

    private static int[] fun(int n, int[][] arr) {

        int[] res = new int[n];
        for (int i = 0; i < arr.length; i++) {
            int begin = arr[i][0];
            int end = arr[i][1];
            int num = arr[i][2];

            for (int j = begin; j <= end; j++) {
                res[j - 1] += num;
            }
        }
        return res;
    }
}
