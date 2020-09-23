package domain.test_month9.AiQiYi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/13 15:44
 * @Version 1.0
 * @Description
 */
/*
给定一个大小为 n 的整数数组，找到其中的多数元素。多数元素是指在数组中出现次数大于『n/2』的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。
输入描述
空格分隔的整数序列，即数组
输出描述
数组中出现最多的整数
样例输入
3 2 3
样例输出
3
 */
public class aiqiyi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");//sc.nextLine()对的，sc.next是错误的
        int[] arr = new int[str.length];
        //System.out.println(str.length);
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.valueOf(str[i]);
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            //System.out.println(arr[i]);
        }
        System.out.println(arr[arr.length/2]);
    }
}
