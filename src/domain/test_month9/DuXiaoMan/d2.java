package domain.test_month9.DuXiaoMan;

import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/20 20:45
 * @Version 1.0
 * @Description
 */
public class d2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        char[][][] puzzle = new char[T][][];

        while (T > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();

            for (int i = 0; i < n; i++) {
                String temp = sc.next();
                System.out.println(temp);
                /*for (int j = 0; j < m; j++) {
                   puzzle[T - 1][i][j] = temp.charAt(j);
                }*/
                //puzzle[n] = temp.toCharArray();
            }
            fun(puzzle, n, m);
            T --;
        }
    }

    private static void fun(char[][][] puzzle, int n, int m) {
        System.out.println( 0);
    }

}
