package domain.test_month9.ALi;

import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/11 9:04
 * @Version 1.0
 * @Description
 */
public class ALi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][]arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[][]res = fun(arr, n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fun(int[][] arr ,int n, int m ) {
        int[][]res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = 0;
                int count = 0;
                if (arr[i][j] == - 1){
                    sum += helper(arr, i + 1, j);
                    if (check(arr, i + 1,j))
                        count++;
                    sum += helper(arr, i - 1, j);
                    if (check(arr, i - 1,j))
                        count++;
                    sum += helper(arr, i, j - 1);
                    if (check(arr, i,j - 1))
                        count++;
                    sum += helper(arr, i, j + 1);
                    if (check(arr, i,j + 1))
                        count++;
                }
                res[i][j] = sum /count;
            }
        }
        return  res;
    }
    public static int helper(int[][]arr, int i, int j ){
        int n = arr.length;
        int m = arr[0].length;
        if (!check(arr, i ,j))
            return 0;
        if (arr[i][j] != -1)
            return arr[i][j];

        if (arr[i][j] == -1 && check(arr, i,j)){
            helper(arr, i + 1, j);
            helper(arr, i - 1, j);
            helper(arr, i, j - 1);
            helper(arr, i, j + 1);
        }
        return 0;

    }
    public static boolean check(int[][] arr, int i ,int j){
        int n = arr.length;
        int m = arr[0].length;
        if (i < 0 || i > n - 1 || j < 0 || j > m - 1 )
            return false;
        return true;
    }
}
