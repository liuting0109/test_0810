package domain.test_month9.WeBank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/27 19:29
 * @Version 1.0
 * @Description
 */
/*
给定一个长度为n的数组a，我们定义一个数x的近似值是在数组a中与x的差值的绝对值最小，如果两个数的绝对值相等，就取较小的那个。比如说对于[2, 5, 7]，4的近似值就是5，而6的近似值应该取5，因为5更小。

现在有q个询问，对每个询问回答近似值。

输入描述
第一行两个整数n, q分别表示数组的长度和查询的次数。(1≤n，q≤1e5)

第二行n个数分别表示a1, a2, a3, … an。(0≤ai≤1e8)

接下来q行每行一个数x表示需要查询的数。(0≤x≤1e8)

输出描述
对于每个询问，输出一个近似值。


样例输入
5 5
1 2 3 4 5
3
0
7
2
5
样例输出
3
1
5
2
5
 */
public class w1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < count; i++) {
            arr[i] = sc.nextInt();
        }
        while (count != 0){
            int num = sc.nextInt();
            fun1(num, arr, n);
            count--;
        }
    }

    private static void fun1(int num, int[] arr, int n) {
        Arrays.sort(arr);
        int index = Arrays.binarySearch(arr, num);
        if (index >= 0){
            System.out.println(arr[index]);
        }else {
            int low = 0 - index - 1;
            if(low == 0){
                System.out.println(arr[0]);
            }else if (index == 0 - arr.length - 1) {
                System.out.println(arr[n - 1]);
            }else {
                int min = Math.abs(num - arr[low]);
                int max = Math.abs(num - arr[low - 1]);

                if (max > min) {
                    System.out.println(arr[low]);
                } else {
                    System.out.println(arr[low + 1]);
                }
            }
        }

    }

    //复杂度过高
    private static void fun(int num, int[] arr, int n) {
        Arrays.sort(arr);
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int min = Math.abs(arr[i] - num);
            if (min < Math.abs(temp - arr[i])){
                temp = arr[i];
            }
        }
        System.out.println(temp);
    }
}
