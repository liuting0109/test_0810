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
3 5
1 2 3
4 6
1 2 3 4
 */
public class b2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- >0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            String res = fun(arr, m, n);
            System.out.println(res);
            //System.out.println("yes");
        }
    }

    private static String fun(long[] arr, long m, int n) {
        Arrays.sort(arr);

        for (int i = 0; i < n /2 + 1; i++) {
            if (arr[i] * arr[n - i - 1] < m){
            }else if (arr[i] * arr[n - i - 1] == m){
                return "yes";
            }else if (arr[i] * arr[n - i - 1] > m){
                if (i == 0)
                    return "no";
                else if ((arr[i - 1] * arr[n - i - 1] == m) || (arr[i] * arr[n - i] == m)){
                    return "yes";
                }else
                    return "no";
            }
        }
        return "no";
    }
}
