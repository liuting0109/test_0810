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
3
1 9
21 21
13 20
 */
public class b3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- >0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int res = fun(n, m);
            System.out.println(res);
        }
    }

    private static int fun(int n, int m) {
        int count = 0;
        for (int i = n; i <= m; i++) {
            if(helper(i)){
                count++;
            }
        }
        return count;
    }

    private static boolean helper(int i) {
        String temp = String.valueOf(i);
        if (i >= 1 && i <= 9){
            return true;
        }
        int[] shuzi = new int[10];
        Arrays.fill(shuzi,0);

        if (temp.contains("0")) shuzi[0] = 1;
        if (temp.contains("1")) shuzi[1] = 1;
        if (temp.contains("2")) shuzi[2] = 1;
        if (temp.contains("3")) shuzi[3] = 1;
        if (temp.contains("4")) shuzi[4] = 1;
        if (temp.contains("5")) shuzi[5] = 1;
        if (temp.contains("6")) shuzi[6] = 1;
        if (temp.contains("7")) shuzi[7] = 1;
        if (temp.contains("8")) shuzi[8] = 1;
        if (temp.contains("9")) shuzi[9] = 1;


        int max = 0;
        int min = 9;
        for (int j = 0; j < 10; j++) {
            if (shuzi[j] == 1){
                max = Math.max(max,j);
                min = Math.min(min, j);
            }
        }
        if (max <= min * 2)
            return true;
        return false;
    }

}
