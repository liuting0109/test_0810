package domain.test_month9;

import javax.xml.stream.events.DTD;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author LT
 * @Date 2020/9/27 22:18
 * @Version 1.0
 * @Description
 */
public class t927 {
    public static void main(String[] args) {

        //并查集
        //https://www.bilibili.com/video/BV13t411v7Fs?p=2
        int[][] arr = {
                {0,1},{1,2},{2,3},{3,4},{4,5}
        };
        BinCha(arr);
    }

    private static void BinCha(int[][] arr) {
        Set<Integer> set = new HashSet<>();//统计有多少个端点
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                set.add(arr[i][j]);
            }
        }
        System.out.println("set大小"+ set.size());
        int[] parent = new int[set.size()];
        Arrays.fill(parent, -1);

        for (int i = 0; i < arr.length; i++) {
            int x = arr[i][0];
            int y = arr[i][1];

            if (union(x,y,parent) == 0){
                System.out.println("circle dected");
                break;
            }else {
                System.out.println("no");
            }
        }
    }

    public static int find_root(int x, int[] parent){
        int x_root = x;
        while (parent[x_root] != -1){
            x_root = parent[x_root];
        }
        return x_root;
    }

    //1 union success;  0 failed
    public static int union(int x, int y, int[] parent){
        int x_root = find_root(x, parent);
        int y_root = find_root(y, parent);
        if (x_root == y_root){
            return 0;
        }else {
            parent[x_root] = y_root;
            return 1;
        }
    }
}
