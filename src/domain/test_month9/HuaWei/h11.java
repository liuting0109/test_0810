package domain.test_month9.HuaWei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/30 18:42
 * @Version 1.0
 * @Description
 */
/*
3 3
1 2 3
4 5 6
7 8 9
 */
    //ac
public class h11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        /*for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("++++++++");*/
        fun(arr, m,n);
    }

    private static void fun(int[][] arr, int m, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int up = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               list.add(arr[i][j]);
            }
        }
        Collections.sort(list);
        /*for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) +" ");
        }*/
        int[][] res = new int[m][n];
        int index = 0;
        while (true){
            for (int col = left; col <= right; col++) {
                res[up][col] = list.get(index++);
            }
            up ++;
            if (up > down)
                break;

            for (int row = up; row <= down; row++) {
                res[row][right] = list.get(index++);
            }
            right--;
            if (left > right)
                break;

            for (int col = right; col >= left; col--) {
                res[down][col] = list.get(index++);
            }
            down--;
            if (up > down)
                break;

            for (int row = down; row >= up; row--) {
                res[row][left] = list.get(index++);
            }
            left++;
            if (left > right)
                break;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }

    }
}
