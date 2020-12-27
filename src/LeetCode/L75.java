package LeetCode;

import java.util.Arrays;

/**
 * @Author LT
 * @Date 2020/12/11 23:24
 * @Version 1.0
 * @Description
 */
public class L75 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 0};
        sortColors(arr);
        for(int i :arr){
            System.out.print(i + " ");
        }
    }
    public static void sortColors(int[] nums) {
        int p0 = 0;
        int cur = 0;
        int p2 = nums.length - 1;
        while (cur <= p2){
          if (nums[cur] == 0){
              swap(nums, cur, p0);
              p0 ++;
              cur ++;
          }else if (nums[cur] == 2){
              swap(nums, cur, p2);
              p2 --;
              //cur ++;//错误！！！因为j交换后的cur可能是0
          }else {
              cur ++;
          }
        }
    }
    public static void swap(int[] arr ,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
