package domain.test_month9.VMware;

import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/26 11:01
 * @Version 1.0
 * @Description
 */
/*
序列维护一直是信息学中的难题。

现在，有一个长度为n的序列（a1,a2...an）需要维护，初始值全为0。每次操作给出三个数 l，r，v，对于每次操作，你需要对于任意的 i（l≤i≤r），将ai加上

最后，你需要输出每个ai的值。

是组合数，其值为  。其中，x！意思为 x 的阶乘，其值为 x *（x-1）*...*1。我们规定0！=1。



输入描述
输入第一行包含一个数n代表数组长度。

输入第二行包含一个数m代表操作次数。

接下来m行，每行3个数，l,r,v

n,m≤100000，v≤100 ,  1≤l≤r≤n

输出描述
输出一行n个数，空格隔开，第 i 个数代表ai最后的值（对998244353取模）


样例输入
4
3
1 4 2
1 3 2
2 4 3
样例输出
2 7 16 20

提示
样例解释：
    a_1  a_2  a_3  a_4
1   +1  +3  +6  +10
2   +1  +3  +6
3         +1   +4  +10
     -------------------
      2     7   16     20
 */
public class v22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[] res = new int[n];

        for (int i = 0; i < m; i++) {
            int[] temp = arr[i];
            int l = temp[0];
            int r = temp[1];
            int v = temp[2];

            for (int j = 0; j < n; j++) {
                if (l - 1 <= j && j <= r - 1){
                    res[j] += jieChen(j+1 + v - l, v);
                }
            }
        }

        for (int j = 0; j < n; j++) {
            res[j] = res[j] % 998244353;
            System.out.print(res[j] +" ");
        }
    }
    public static int jieChen(int n ,int m){
        int res = 0;

        int a = 1;
        for (int i = 1; i <= n; i++) {
            a *= i;
        }
        int b = 1;
        for (int i = 1; i <= m; i++) {
            b *= i;
        }
        int c = 1;
        for (int i = 1; i <= n - m; i++) {
            c *= i;
        }
        res = a/(b * c);

        return res;
    }
}
