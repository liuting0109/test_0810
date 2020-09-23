package domain.test_month9.BaiDu;

import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/14 20:00
 * @Version 1.0
 * @Description
 */
/*
4
1 1 1 1
0 1 0 1
1 1 0 1
0 0 1 0
 */
public class baidu2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                //if (sc.next() == "1" ||sc.next() == "0")
                arr[i][j] = Integer.valueOf(s.charAt(j) - '0');
            }
        }
        fun2(arr,n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    private static void fun2(int[][] arr, int n) {
        int left = 0, right = 0, up = 0, down = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == 0){
                    left = j;
                    while (j < n - 1 && arr[i][j] == 0){
                        j++;
                    }
                    right = j;
                    up = i;
                    while (i < n - 1 && arr[i][left] == 0){
                        i++;
                    }
                    down = i;
                    if(check(arr, left, right, up ,down)){
                        for (int m = up; m < down; m++) {
                            for (int k = left; k < right; k++) {
                                arr[m][k] = 1;
                            }
                        }
                    }
                }

            }
        }

    }

    private static boolean check(int[][] arr, int left, int right, int up, int down) {
        for (int i = left; i < right; i++) {
            if (arr[up - 1][i] == 0)return false;
        }
        for (int i = left; i < right; i++) {
            if (arr[down ][i] == 0)return false;
        }
        for (int i = up; i < down; i++) {
            if (arr[i][left - 1] == 0)return false;
        }
        for (int i = up; i < down; i++) {
            if (arr[i][right] == 0)return false;
        }
        return true;
    }
}
