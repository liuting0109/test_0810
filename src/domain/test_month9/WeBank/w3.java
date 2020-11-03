package domain.test_month9.WeBank;

import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/27 20:19
 * @Version 1.0
 * @Description
 */
public class w3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int res = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] <= arr[j]){
                    for (int k = j + 1; k < n; k++) {
                        if (arr[j] <= arr[k]){
                            res++;
                        }else
                            continue;
                    }
                }else
                    continue;
            }
        }
        System.out.println(res);
    }
}
