package domain.test_month9.WanMei;

import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/24 18:55
 * @Version 1.0
 * @Description
 */
/*
搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。

输入描述
第一行：要寻找的目标
第二行：旋转过的数组
输出描述
目标元素在旋转数组中的索引， -1表示没有找到
样例输入
5
15 16 19 20 25 1 3 4 5 7 10 14
样例输出
8

旋转数组长度范围在[1, 1000000]之间
 */
public class w2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        String[] arr = s.split(" ");
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }

        int result = search(nums, target);

        System.out.println(result);
    }

    public static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                return i;
        }
//todo 实现算法
        return -1;
    }
}
