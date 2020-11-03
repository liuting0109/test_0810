package domain.test_month10.BeiKe;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/10/26 19:06
 * @Version 1.0
 * @Description
 */
/*
2
4 6 7
3 6 6
 */
public class b1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] arr = new int[T][3];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
            fun(arr[i]);
        }
    }

    private static void fun(int[] arr) {
        Arrays.sort(arr);
        int x = arr[0];
        int y = arr[1];
        int z = arr[2];
        if ((x != y) && (x != z) && (y != z)){
            System.out.println("NO");
            return;
        }
        if ((x != y) && (y == z)){
            System.out.println("YES");
            System.out.println(x - 1 +" "+ x + " "+ z);
            return;
        }
        if ((x == y) && (x == z) && (y == z)){
            System.out.println("YES");
            System.out.println(x +" "+ x + " "+ x);
            return;
        }
    }
}
