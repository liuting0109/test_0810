package domain.test_month10.ShenXinFu;

import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/10/15 19:50
 * @Version 1.0
 * @Description
 */
public class s1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] arr = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int res = fun1(x , y, arr);
        System.out.println(res);
    }
    static boolean[][] vistit = new boolean[10][10];
    private static int fun1(int x, int y, int[][] arr) {
        if (x > 9 || x < 0 || y > 9 || y < 0)
            //return ;
        vistit[x][y] = true;
        for (int i = x; i < 10; ) {

            for (int j = y; j < 10; ) {

            }
        }
        return 16;
    }
}
