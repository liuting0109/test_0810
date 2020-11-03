package domain.test_month9.BeiKe;

import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/7 15:31
 * @Version 1.0
 * @Description
 */
/*
2
6 5 8 9
1 20 1 0
 */
public class BeiKe4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[2 * n];
        int[] b = new int[2 * n];
        for (int i = 0; i < 2*n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < 2*n; i++) {
            b[i] = sc.nextInt();
        }
        int res = fun(a, b, n);
        System.out.println(res);
    }

    private static int fun(int[] a, int[] b, int n) {
        int res = 0;
        int left = n - 1;
        int right = n;
        int[] temp = new int[2*n];
        for (int i = 0; i < 2*n; i++) {
            temp[i] = b[i] - a[i];
        }
        res = 0;
        int blood = 0;
        while (left >= 0 && right <= 2*n - 1){
            if (temp[left] > temp[right]){
                res = Math.max(res, Math.abs(blood - temp[left]));
                blood += temp[left];
                left--;
            }else if (temp[left] < temp[right]){
                res = Math.max(res, a[right]+1);
                blood += temp[right];
                right++;
            }else if (temp[left] == temp[right]){
                if (b[left] < b[right]){
                    blood += temp[right];
                    right++;
                }else {
                    blood += temp[left];
                    left--;
                }
            }
        }
        return res;
    }
}
