package domain.test_month10.ShenXinFu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author LT
 * @Date 2020/10/15 19:50
 * @Version 1.0
 * @Description
 */
/*
2
5
12 89 34 66 20
67 16 24 95 42
3
1 2 3
6 5 4
 */
    //ac 田忌赛马
public class s2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();//测试组

        while (T -- > 0) {
            int N = sc.nextInt();
            int[] A = new int[N];
            int[] B = new int[N];

            for (int i = 0; i < N; i++) {//齐王
                A[i] = sc.nextInt();
            }
            for (int i = 0; i < N; i++) {//田忌
                B[i] = sc.nextInt();
            }

            int [] res = fun(A , B , N);
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < N - 1; i++) {
                sb.append(res[i] + " ");
            }
            sb.append(res[N - 1]);
            System.out.println(sb.toString());
        }


    }

    private static int[] fun(int[] A, int[] B, int n) {
        //HashMap<Integer, Integer> mapA = new HashMap<>();
        HashMap<Integer, Integer> mapB = new HashMap<>();
        for (int i = 0; i < n; i++) {
            //mapA.put(A[i], B[i]);
            mapB.put(B[i], i);
        }
        int[] aa = A.clone();
        int[] bb = B.clone();
        Arrays.sort(aa);//齐王
        Arrays.sort(bb);//田忌

        HashMap<Integer, Integer> duiYin = new HashMap<>();
        for (int i = 0; i < n; i++) {
            duiYin.put(aa[i], bb[i]);
        }

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int temp = duiYin.get(A[i]);
            int location = mapB.get(temp);
            res[i] = location;
        }

        for (int i = 0; i < n; i++) {
            res[i] += 1;
        }

        return res;
    }


}
