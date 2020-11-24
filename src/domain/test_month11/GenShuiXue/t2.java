package domain.test_month11.GenShuiXue;

import java.util.Scanner;
/*
假设一个云服务器集群由M台节点组成，给定N个任务及每个任务预估的执行时间，计算这M台节点完成所有N个任务所需的最短时间， N >> M。
输入描述
第一行包含两个整数，第一个整数代表节点数M，第二个数代表任务数N
第二行包含M个整数，代表N个任务各自的执行时间
输出描述
输出一行，包含一个整数，代表M个节点执行完全部N个任务所需的最短时间
样例输入
2 5
1 3 5 2 4
样例输出
8
 */
/**
 * @Author LT
 * @Date 2020/11/6 19:32
 * @Version 1.0
 * @Description
 */
//ac
public class t2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        fun(arr, m, n);
    }

    private static void fun(int[] arr, int m, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        sum = sum/m + 1;
        System.out.println(sum);

    }

}
