package domain.test;

import java.util.Scanner;
/*
https://zihao.blog.csdn.net/article/details/108350913
上面四题全A

 对于一个边长为n的方阵，依照中心横线，中心竖线，两个对角线，
 米字划分8个区域，逆时针填入1-8数字把矩阵分成把部分，每部分填入该部分对应的数字，横线处填0
 ac
 */
public class Pingduoduo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] array = new int[n][n];
        array = miMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] +" ");
            }
            System.out.println();
        }
    }

    public static int[][] miMatrix(int n){
        int[][] array = new int[n][n];
       /* array[0][n - 2] = 1;
        array[0][1] = 2;
        array[1][0] = 3;
        array[n - 2][0] = 4;
        array[n - 1][1] = 5;
        array[n - 1][n - 2] = 6;
        array[n - 2][n - 1] = 7;
        array[1][n - 1] = 8;*/
        if (n % 2 == 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ((i <= n/2 - 1) && (n/2 <= j) && (i + j < (n - 1))){
                        array[i][j] = 1;
                    }else if ((i <= n/2 - 1) && (n/2 > j) && (i < j )){
                        array[i][j] = 2;
                    }else if ((i <= n/2 - 1) && (n/2 > j) && (i > j)){
                        array[i][j] = 3;
                    }else if ((i >= n/2) && (n/2 > j) && (i + j < (n - 1))){
                        array[i][j] = 4;
                    }else if ((i >= n/2) && (n/2 > j) && (i + j > (n - 1))){
                        array[i][j] = 5;
                    }else if ((i >= n/2) && (n/2 <= j) && (i > j )){
                        array[i][j] = 6;
                    }else if ((i >= n/2) && (n/2 <= j) && (i < j )){
                        array[i][j] = 7;
                    }else if ((i <= n/2 - 1) && (n/2 <= j) && (i + j > (n - 1))){
                        array[i][j] = 8;
                    }

                }
            }
        }
        if (n % 2 != 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ((i <= n/2 - 1) && (n/2 < j) && (i + j < (n - 1))){
                        array[i][j] = 1;
                    }else if ((i <= n/2 - 1) && (n/2 > j) && (i < j )){
                        array[i][j] = 2;
                    }else if ((i <= n/2 - 1) && (n/2 > j) && (i > j)){
                        array[i][j] = 3;
                    }else if ((i > n/2) && (n/2 > j) && (i + j < (n - 1))){
                        array[i][j] = 4;
                    }else if ((i >= n/2) && (n/2 > j) && (i + j > (n - 1))){
                        array[i][j] = 5;
                    }else if ((i >= n/2) && (n/2 < j) && (i > j )){
                        array[i][j] = 6;
                    }else if ((i > n/2) && (n/2 < j) && (i < j )){
                        array[i][j] = 7;
                    }else if ((i <= n/2 - 1) && (n/2 < j) && (i + j > (n - 1))){
                        array[i][j] = 8;
                    }
                }
            }

        }
        return array;
    }
}
