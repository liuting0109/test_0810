package domain.test;

import java.util.Scanner;

public class Didi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] res = fun(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j]+ " ");
            }
            System.out.println();
        }
    }
    public static long[][] fun(int n){
        long[][] res = new long[n][n];
        if (n <= 0)
            return res;
        if (n == 1) {
            res[0][0] = 1;
            return res;
        }
        long[] fib = new long[n*n + 1];
        fib[1] =  1;
        fib[2] = 1;
        for (int i = 3; i < n*n + 1; i++) {
            fib[i] = fib[i - 1]+ fib[i - 2];
        }
        /*for (int i = 0; i < n*n +1; i++) {
            System.out.println(fib[i]);
        }*/
        int up = 0;
        int down = n -1;
        int left = 0;
        int right = n - 1;
        int index = n*n;
        while (true){
            for (int col = left; col <= right ; col++){
                res[up][col] = fib[index --];
            }
            up++;
            if (up > down) break;

            for (int row = up; row <= down ; row++){
                res[row][right] = fib[index --];
            }
            right--;
            if (left > right) break;

            for (int col = right; col >= left ; col--){
                res[down][col] = fib[index --];
            }
            down -- ;
            if (up > down) break;

            for (int row = down; row >= up ; row--){
                res[row][left] = fib[index --];
            }
            left++;
            if (left > right) break;
        }
        return res;
    }
}
