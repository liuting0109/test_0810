package domain.test_month9.NetEase;

import java.util.Scanner;

public class Neteas3 {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] res = new int[T];
        //int[][][] temp = new int[][][];
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[][] path = new int[n][2];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    path[j][k] = sc.nextInt();
                }
            }
            res[i] = pazzle(path, n);
        }
        for (int i = 0; i < T; i++) {
            System.out.println(res[i]);
        }*/
        int n = 2;
        int[][] path = {{3,1}, {3,1}};
        pazzle(path, n);
        /*int n = 8;
        int[][] path = {{0,1}, {0,1},{3,1},{3,1},{1,1},{1,1},{2,1},{0,1}};*/
       /* int n = 10;
        int[][] path = {{0,1},{0,-1},{1,1},{1,1},{1,-1},{0,1},{2,1},{2,-1},{3,1},{3,1}};
        pazzle(path, n);*/
    }

    public static int pazzle(int[][] path, int n){
        int res = 0;
        boolean[][] flag = new boolean[100][100];
        //System.out.println(flag[0][0]);
        int [][] yuanDian = new int[n][n];
        int x = 50, newX = 50;
        int y = 50, newY = 50;

        for (int i = 0; i < n; i++) {
            if (path[i][0] == 0 && path[i][1] == 1){
                newY += 1;
            }else {
                flag[newX][newY] = true;
            }
            if (path[i][0] == 1 && path[i][1] == 1){
                newY -= 1;
            }else {
                flag[newX][newY] = true;
            }
            if (path[i][0] == 2 && path[i][1] == 1){
                newX -= 1;
            }else {
                flag[newX][newY] = true;
            }
            if (path[i][0] == 3 && path[i][1] == 1){
                newX += 1;
            }else {
                flag[newX][newY] = true;
            }
        }
        int m1 =  Math.abs(x - newX);
        int m2 = Math.abs(y - newY);

        //System.out.println(res);
        return res;
    }
}
