package domain.test_month11.GenShuiXue;

import java.util.Scanner;
/*
将一个N*N的方阵旋转180度
输入描述
第一行包含一个正整数n，代表方阵的阶数
之后n行每行包含n个整数，代表方阵第n行的n个元素
输出描述
输出n行，每一行包含旋转后矩阵第n行的n个元素
样例输入
3
1 2 3
4 5 6
7 8 9
样例输出
9 8 7
6 5 4
 */
/**
 * @Author LT
 * @Date 2020/11/6 19:32
 * @Version 1.0
 * @Description
 */
//ac
public class t1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        fun(arr, n);
    }

    private static void fun(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[n - 1 -i][n -1 -j] +" ");
            }
            System.out.println();
        }

    }
}
