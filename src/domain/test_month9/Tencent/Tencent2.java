package domain.test_month9.Tencent;

import java.util.HashSet;
import java.util.Scanner;
/*
给定n个人和m个人的小团体，消息从0开始传播，问传播到多少人
一个小团队只要有一个人知道了  其他都会知道 同时还是通知他其他团队的人
50 5
2 1 2
5 10 11 12 13 14
2 0 1
2 49 2
4 6 7 8 2

输出7
（0 1 2 6 7 8 49）
 */
//正解
public class Tencent2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] teams = new int[m][];
        for (int i = 0; i < m; i++) {//写法记住！利用一维数组暂存，然后存到二维数组里面
            int len = sc.nextInt();
            int[] team = new int[len];
            for (int j = 0; j < len; j++) {
                team[j] = sc.nextInt();
            }
            teams[i] = team;
        }

        HashSet<Integer> knows = new HashSet<>();
        knows.add(0);
        for (int k = 0; k < m; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < teams[i].length; j++) {
                    if (knows.contains(teams[i][j])){
                        for (int j2 = 0; j2 < teams[i].length; j2++) {
                            knows.add(teams[i][j2]);
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(knows.size());
    }

}
