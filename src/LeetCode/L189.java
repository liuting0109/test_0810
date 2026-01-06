package LeetCode;

import java.util.Arrays;

/**
 * @Author: liuting
 * @Date: 2026/1/5 10:03
 * @Description:
 */
public class L189 {
    //轮转数组
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};//输出[5,6,7,1,2,3,4]
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    //时间复杂度：O(n)，其中 n 是 nums 的长度。
    //空间复杂度：O(1)
    public static void rotate(int[] nums, int k) {
        int n = k % nums.length; //计算轮转的次数
        if (n == 0) return;//若为数组续长度的倍数，相当于没有轮转。
        reverse(nums, 0, nums.length - 1);//反转数组[7, 6, 5, 4, 3, 2, 1]
        reverse(nums, 0, n - 1); //反转前n个 [5,6,7,4,3,2,1]
        reverse(nums, n, nums.length - 1);//反转后nums.length-n个 [5,6,7,1,2,3,4]
    }

    //反转数组
    public static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}

