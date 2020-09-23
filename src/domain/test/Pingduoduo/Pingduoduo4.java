package domain.test.Pingduoduo;

import java.util.HashSet;
import java.util.Scanner;
/*
给定n和m个数(a_1, a_2, ..., a_m)，求1-n中有多少数可以整除至少一个a_i
ac50%
 */
public class Pingduoduo4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] array = new int[M];
        for (int i = 0; i < M; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println(fun4(array, N, M));



        //压缩？容量互斥
        long ed = pw(2, M), ans = N;
        for (int i = 1; i < ed; i++) {
            long cnt = 0, tmp = 1;
            for (int j = 1; j <= M; j++) {
                if ((i & (1 << (j - 1))) != 0) {
                    cnt++;
                    tmp = tmp / gcd(tmp, array[j]) * array[j];
                }
            }
            if (cnt % 2 == 1) ans -= (N / tmp);
            else ans += (N / tmp);
        }
        System.out.println(N - ans);
    }
    //ac
    public static long pw(long a, long b) {
        long ans = 1, base = a;
        while (b != 0) {
            if (b % 2 == 1) ans = (ans * base);
            base = (base * base);
            b >>= 1;
        }
        return ans;
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    //ac 50%
    private static int fun4(int[] array, int n, int m) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int tezhen = array[i];
            for (int k = 1; k <= n; k++) {
                if (k % tezhen == 0){
                    set.add(k);
                }
            }
            for (int j = 1; j < i; j++) {
                if (tezhen == array[j])
                    continue;
                else {
                    for (int k = 1; k <= n; k++) {
                        if (k % tezhen == 0){
                            set.add(k);
                        }
                    }
                }
            }

        }
        return set.size();
    }


}
