package domain.test_month9.VMware;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author LT
 * @Date 2020/9/21 21:13
 * @Version 1.0
 * @Description
 */
/*
油漆工文文接到了任务。在艺术展上一共有n面墙需要他刷成对应的颜色，从左到右分别标号为1,2...,n。每一面墙在最开始的时候都有一个独一无二的颜色。所有墙的颜色会使用一个长度为n的全排列p表示。

由于艺术家们非常苛刻，所以刷墙只能从某一面墙上取色，取完色之后，为了防止颜色变化，只能用来刷与这面墙相邻的墙，并且被刷的墙一定会全部被刷成另外一种颜色。

给出开始的墙上颜色，请问文文能不能把墙刷成要求的样子呢？



输入描述
第一行一个数 T，代表数据组数(1≤T≤10^5 )

接下来 T 组数据，每一组第一行为一个数 n(1≤n≤10^5 ) 代表墙数

第二行n个数p1,p2,...pn(1≤pi≤n)表示每面墙开始的颜色，每种颜色出现且仅出现一次。

第三行n个数b1,b2,...bn(1≤bi≤n)表示每面墙需要被刷成的颜色。

输出描述
对于每一组测试数据，如果文文可以把墙全部刷成需要的样子，则输出一行一个 “YES” （全部大写）否则则输出一行一个 “NO” （全部大写）


样例输入
2
5
1 2 3 4 5
1 1 3 3 5
10
10 2 9 8 3 6 7 1 4 5
2 8 6 6 6 6 5 5 5 5
样例输出
YES
YES

提示
样例解释
第一行T为2，代表接下来有两组，
第一组有5面墙，原始颜色为1 2 3 4 5，希望涂成1 1 3 3 5
从第一面墙上取色刷到第二面墙，第三面墙上取色刷到第四面墙，故为YES。
第二组有10面墙，原始颜色和希望涂色如上
从第二面墙取色将2刷到第一面，从第四面墙取色8一直刷到第二面墙，然后6再一直刷到第三面墙，5一直刷到第七面墙，故为YES。
 */
public class v2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] yuan = new int[n];
            for (int j = 0; j < n; j++) {
                yuan[i] = sc.nextInt();
            }

            int[] shua = new int[n];
            for (int j = 0; j < n; j++) {
                shua[j] = sc.nextInt();
            }
            String res = fun(yuan,shua,n);
            System.out.println(res);
        }
    }

    private static String fun(int[] yuan, int[] shua, int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(shua[i]);
        }
        if (set.size() < n){
            return "YES";
        }
        return "NO";
    }
}
