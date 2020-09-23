package domain.test_month9.AiQiYi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/13 15:44
 * @Version 1.0
 * @Description
 */
/*
空格分隔的整数序列

输出描述
每行是一个空格分隔的三个整数，即三元组。输出顺序要求：1、行内按数字大小排列，小的元素排在前面；2、行间按三元组大小排列（如果两个三元组的第一个元素不一样，则三元组大小取决于第一个元素的大小，否则取决于下一个元素的比较，以此类推）


样例输入
-1 0 1 2 -1 -4
样例输出
-1 -1 2
-1 0 1
 */
public class aiqiyi3 {
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int[] arr = new int[str.length];
        //System.out.println(str.length);
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.valueOf(str[i]);
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            //System.out.println(arr[i]);
        }
        threeSum(arr);
        //System.out.println(res);
        for (List<Integer> list: res){
            List<Integer> ll = list;
            for (Integer i : ll){
                System.out.print(i+ " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> threeSum(int[] arr){
        Arrays.sort(arr);
        int n = arr.length;
        if (arr == null || n < 3)
            return res;
        for (int i = 0; i < n - 2; i++) {
            if (arr[i] > 0) break;
            if (i > 0 && arr[i] == arr[i - 1])continue;
            int left = i + 1;
            int right = n - 1;
            while (left < right){
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[left]);
                    list.add(arr[right]);
                    res.add(list);
                    while (left < right && arr[left] == arr[left + 1])
                        left++;
                    while (left < right && arr[right] == arr[right - 1])
                        right--;
                    left ++;
                    right --;
                }else if (sum < 0) {
                    //while (left < right && arr[left] == arr[left++])
                        left++;}
                else if (sum > 0) {
                   // while (left < right && arr[right] == arr[right--])
                        right--;
                }
            }
        }
        return res;
    }
}
