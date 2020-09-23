package domain.test_month9.ShangTang;

import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/18 19:28
 * @Version 1.0
 * @Description
 */
public class st1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] arr = new char[n][m];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.next().toCharArray();
            }
            System.out.println("YES");
        }
    }
}
