package domain.test;

import java.util.Scanner;

public class YuanFuDao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(fun(matrix, N, M));
        /*int[][] matrix1 = {{2,1,3},{3,-2,4}};
        System.out.println(fun(matrix1, 2, 3));*/
    }

    private static int fun(int[][] matrix, int n, int m) {
        int sum = 0;
        int[] sumOfCol = new int[m*2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sumOfCol[i] += matrix[j][i];
            }
        }
        for (int i = m; i < m*2; i++) {
            sumOfCol[i] = sumOfCol[i - m];
        }
        int res = 0;
        for (int i = 0; i < m*2; i++){
            int start = i;

            sum = sum > 0? sum + sumOfCol[i]:sumOfCol[i];
            res = Math.max(sum, res);
        }
        return res/2;
    }
}
