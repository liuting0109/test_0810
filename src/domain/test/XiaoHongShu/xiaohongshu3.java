package domain.test.XiaoHongShu;

import java.util.Scanner;
//答案
// https://www.cnblogs.com/GDOI2018/p/9732757.html
/*
一个n*m的宝箱矩阵，每个宝箱中有一定数量的金币，
你需要从这个矩阵中选出r行c列的子矩阵，使得这个子矩阵中每两个相邻的宝箱的金币差之和最小（相邻包括上下左右四个方向）。

输入描述
n m r c (n行m列的矩阵中选择r行c列, 0<r<=n, 0<c<=m)

接下来的n行，每行包含m个用空格隔开的整数，表示宝箱内的金币数。

输出描述
1个整数(子矩阵中相邻宝箱的金币差之和的最小值)
样例输入
4 4 2 2
5 4 2 6
4 10 1 8
1 9 3 10
6 4 8 3
样例输出
4

提示
样例说明
取第1行、第4行与第1列、第2列得到子矩阵
5 4
6 4
每两个相邻的宝箱的金币差之和为(两个相邻宝箱只计算一次)
|5−4| + |5−6| + |4−4| + |6−4| =4

数据说明
对于50%的数据，n <=12，m <= 12，每个宝箱中的金币数不超过20
对于100%的数据， n <= 16， m <= 16，每个宝箱中的金币数不超过1,000
 */
public class xiaohongshu3 {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            if (i % 7 == 0){
                System.out.println(i);
                break;
            }
        }

        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] array = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        System.out.println(fun(array, n, m , r, c));*/
    }

    private static int fun(int[][] array, int n, int m, int r, int c) {
        int res = 0;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int a = array[i][j];

            }
        }
        return res;
    }

}
