package domain.test_month9.Netease0912;

import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/12 15:33
 * @Version 1.0
 * @Description
 */
public class n4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] boy = sc.nextLine().split(" ");
        String[] girl = sc.nextLine().split(" ");
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(boy.length);
    }
}
