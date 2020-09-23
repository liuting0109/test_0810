package domain.test.XunFei;

import java.util.Scanner;
//棋盘从左上走到右下角 只能向右向下走 求最大的和
//剑指47 leetcode 47.
/*
礼物价值最大化
 *  思路：创建一个二维数组dp[][],dp[i][j]代表的是从二维数组的左上角元素走到dp[i][j]这个单元格的最大价值
 *  状态转移方程为：dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + dp[i][j]
 */
public class xunfei1 {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[m][n] = sc.nextInt();
            }
        }

        int[][] res = fun1(array);
        System.out.println(res[m - 1][n - 1]);*/
        int[][] array = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] res = fun1(array);
        System.out.println(res[2][2]);
    }

    private static int[][] fun1(int[][] num) {
        int m = num.length;
        if (m == 0)
            return new int[0][0];
        int n = num[0].length;
        int[][] res = new int[m][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (i == 0 && j == 0) {
                    res[i][j] = num[i][j];
                    continue;
                }
                if (j == 0) {
                    res[i][j] = res[i - 1][j] + num[i][j];
                    continue;
                }
                if (i == 0) {
                    res[i][j] = res[i][j - 1] + num[i][j];
                    continue;
                }
                int max = Math.max(res[i][j - 1], res[i - 1][j]);
                res[i][j] = max + num[i][j];
            }
        }
        return res;
    }

    //f(i, j) = max{f(i - 1, j), f(i, j - 1)} + grid[i][j]
    public int maxValue(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        /*int [][] dp = new int[n][m];
        dp[0][0] = grid[0][0];*/
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0){
                    continue;
                }else if (i == 0){
                    grid[i][j] += grid[i][j - 1];
                }else if (j == 0){
                    grid[i][j] += grid[i - 1][j];
                }else {
                    grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[n - 1][m - 1];
    }

}
