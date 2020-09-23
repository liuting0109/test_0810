package domain.test_month9.VMware;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author LT
 * @Date 2020/9/21 21:12
 * @Version 1.0
 * @Description
 */
/*
小A所在小区发生了偷窃案件。现在，人们已经确定了小偷来自自己的小区，并且恰好有2人。
小区里面有n个人，每个人对周围的其他人都有一定印象，所以大家决定投票选出最可疑的人。
每个人拥有两票，用来投自己认为可疑的人。小区物业认为，一个人投的两人中至少有一人是真正的小偷，就认为这个人有敏锐的嗅觉。
小区物业想知道，有多少组可能的小偷组合，使整个小区拥有敏锐嗅觉的人至少有K个？

输入描述
输入第一行包含两个整数n，K，即小区的人数。K的含义如题目所示。
接下来n行，每行两个整数ai，bi，代表第i个人投的两票。数据保证对于任意i，ai与bi不相同，但是一个人可能投自己的票。
1≤K≤n≤100000
输出描述
输出一个整数，代表有多少种可能的小偷组合。
样例输入
4 4
1 2
2 3
1 4
1 3
样例输出
2

提示  样例解释  有[1,2][1,3]两种
 */
public class v1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int K = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        fun(arr, K, n);

    }

    private static void fun(int[][] arr, int k, int n) {
        int res = 0;
        for (int i = 1; i <= n - 1; i++) {
            for (int j =  i + 1; j <= n ; j++) {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                set.add(j);
                int count = 0;
                for (int l = 0; l < n; l++) {
                    if (set.contains(arr[l][0]) || set.contains(arr[l][0])){
                        count++;
                    }
                }
                if (count >= k){
                    res++;
                }
            }
        }
        System.out.println(res);
    }

}
