package domain.test_month9.HuaWei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/30 18:42
 * @Version 1.0
 * @Description
 */
/*
3 3
1 2
2 3
1 3

5 4
1 2
2 3
3 4
4 5


有向图！！！
和无向图有区别！！
 */
public class h33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        fun(arr, n, m);
    }

    private static void fun(int[][] arr, int n, int m) {
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);
        int count = 0;
        for (int i = 0; i < m; i++) {
            int x = arr[i][0];
            int y = arr[i][1];
            if(merge(x,y, parent) == 0){
                continue;
            }else {
                count++;
            }
        }

        for (int i = 0; i < m; i++) {
            int x = arr[i][0];
            int y = arr[i][1];
            for (int j = i+ 1; j < m; j++) {
                int xx = arr[j][0];
                int yy = arr[j][1];
                if ((xx == y) && (yy == x)){
                    count ++;
                }
            }
        }

        System.out.println(count);
    }

    //1表示连接成功，0表示失败
    private static int merge(int x, int y, int[] parent) {

        int xroot = find_root(x, parent);
        int yroot = find_root(y, parent);
        if (xroot == yroot){
            return 0;
        }else {
            parent[xroot] = yroot;
            return 1;
        }
    }
    public static int find_root(int x, int[] parent){
        int x_root = x;
        while (parent[x_root] != -1){
            x_root = parent[x_root];
        }
        return x_root;
    }

}
