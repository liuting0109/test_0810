package domain.test_month9.BaiDu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/14 20:00
 * @Version 1.0
 * @Description
 */
/*
题目描述：
小明在网上下载了n个文件{F1,F2,F3,…,Fn}，他需要把这些文件存放到大小为M的U盘中，文件i的大小为Si，1<=i<=n。

请你设计一个算法来提供一个存储方案，使得在小明的U盘中存储的文件个数最多。



输入描述
单组输入。

对于每组测试数据，每1行的第1个数字表示U盘的容量M（以MB为单位，不超过1000000MB），第2个数字表示待存储的文件个数n。

第2行包含n个正整数，分别对应待存储的n个文件的大小（以MB为单位）。

输出描述
输出最多可以存放的文件个数。


样例输入
10000 5
2000 1000 5000 3000 4000
样例输出
4

提示
输入样例2
1 2
3 3
输出样例2
0
 */
//ac
public class baidu1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int memory = sc.nextInt();
        int n =sc.nextInt();
        int[] file = new int[n];
        for (int i = 0; i < n; i++) {
            file[i] = sc.nextInt();
        }
        fun1(file, memory);

    }
    public static void fun1(int[] file, int memory){
        Arrays.sort(file);
        int count = 0;
        int sum = 0;
        for (int i = 0; i < file.length; i++) {
            if (sum + file[i] <= memory){
                sum += file[i];
                count++;
            }else if (sum + file[i] > memory){
                break;
            }
        }
        System.out.println(count);
    }
}
