package domain.test_month9.WeBank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/27 19:54
 * @Version 1.0
 * @Description
 */
/*
平面上有一个矩形，大小为n×m，其中，长度为n的边是竖直的，长度为m的边是水平的。将矩形切割成n×m个小正方形，规定左上角的小正方形属性值为（1,1）,左下角的小正方形属性值为（n,1）,右上角的小正方形属性值为（1,m）,右下角的小正方形属性值为（n,m）。我们规定从上往下数第x行，从左往右数第y列的小正方形属性值为(x,y).

现在，我们对这个矩形进行如下操作，将其顺时针旋转90度x次，然后将其水平翻转y次，然后将其逆时针旋转90度z次。

接着，我们将这个操作后的矩形按原始的思路重新标上属性值，每一个小正方形就有一个原来的属性值和新的属性值。

然后有Q个询问，每一次询问一个原来属性值为(x,y)的小正方形的新属性值。你需要对所有询问作出回答。



输入描述
输入第一行包含三个数  x ,y ,z ，代表顺时针旋转，水平翻转，逆时针旋转的次数。

接下来一行两个数，n,m代表原矩形的大小。

接下来一行一个数，Q代表询问次数。

接下来Q行，每行两个数 x,y 代表一次询问，询问原矩形中属性值为（x,y）的小正方形现在的新属性值。

1≤x,y,z≤10^6；1≤n,m,Q≤1000；1≤x≤n；1≤y≤m

输出描述
输出包含Q行，每一行一个答案。


样例输入
1 1 1
4 5
3
1 1
3 4
2 5
样例输出
4 1
2 4
3 5

提示
样例解释：
（1,1）->（1,4）->（1,1）->（4,1）
（3,4）->（4,2）->（4,3）->（2,4）
（2,5）->（5,3）->（5,2）->（3,5）
规则
 */
public class w2 {
    static int a;
    static int b;
    public static void main(String[] args) {
        /*int[]arr = {1,2,3,5};
        int index = Arrays.binarySearch(arr, 4);
        System.out.println(index);*/
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();

        String[][] arr = new String[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = new String((i+1) +" "+ (1+j));
            }
        }

        int Q = sc.nextInt();
        while (Q != 0){
            a = sc.nextInt();
            b = sc.nextInt();
            fun(x, y, z, n, m, a, b);
            Q--;
        }
    }

    private static void fun(int x, int y, int z, int n, int m, int a, int b) {
        x = x% 4;
        y = y % 4;
        z = z% 4;
        funx(n, m);
    }

    private static void funx(int n, int m) {
        //int[][] temp = new int[m][n];
        int d = n - 1;

    }
    private static void funy(int n, int m) {
        b = m - b;
    }

    private static void funz(int n, int m) {

    }

}
