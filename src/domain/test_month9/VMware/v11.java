package domain.test_month9.VMware;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/26 10:29
 * @Version 1.0
 * @Description
 */
/*
给你一个长度为n的数组A和一个长度为m的数组B，以及一个模数mod，你需要从数组A里选取一个数x，从数组B中选取一个数y，使得(x+y)%mod的值是所有选取方式中最小的，输出这个最小值即可。



输入描述
第一行三个整数n，m，mod，分别表示A数组的长度、B数组的长度以及模数。

第二行n个整数，第i个数表示A数组中第i个数的大小。

第三行m个整数，第i个数表示B数组中第i个数的大小。

数字间均以空格隔开。

1 <= n, m <= 100000

1 <= A[i], B[i], mod <= 10^18

输出描述
一个整数x，表示求得的最小值。


样例输入
4 5 10
2 3 4 5
1 2 3 4 6
样例输出
0

提示
样例输入2
2 2 100000000007
27234626274 344569274255
9237235275 23974652789327

样例输出2
1887413921
 */
public class v11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        BigDecimal mod = sc.nextBigDecimal();

        BigDecimal[] arr1 = new BigDecimal[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextBigDecimal();
        }

        BigDecimal[] arr2 = new BigDecimal[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextBigDecimal();
        }
        //System.out.println(5 % 12);
        /*String str1 = sc.next();
        System.out.println("str1"+ str1);
        String[] arr1 = str1.split(" ");
        String str2 = sc.next();
        System.out.println("str2"+ str2);
        String[] arr2 = str2.split(" ");*/
        fun(arr1, arr2, n, m, mod);
    }

    private static void fun(BigDecimal[] arr1, BigDecimal[] arr2, int n, int m, BigDecimal mod) {
        BigDecimal min = mod;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                BigDecimal temp = arr1[i];
                BigDecimal sum = temp.add(arr2[j]);

                BigDecimal yy = sum.divideAndRemainder(mod)[1];
                /*BigDecimal[] c = sum.divideAndRemainder(mmod);
                BigDecimal yushu = c[1].compareTo(new BigDecimal(0)) == 0? c[1] :new BigDecimal(0);*/
                if (min.compareTo(yy) == 1){
                    min = yy;
                }
            }
        }

        System.out.println(min);
    }


}
