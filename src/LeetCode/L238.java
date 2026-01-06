package LeetCode;

import java.util.Arrays;

/**
 * @Author LT
 * @Date 2020/12/27 15:46
 * @Version 1.0
 * @Description
 */
public class L238 {
    //除了自身以外数组的乘积
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4};//输出[24,12,8,6]
//        int[] num = {-1, 1, 0, -3, 3};//输出[0,0,9,0,0]
        int[] res = productExceptSelf(num);
        System.out.println(Arrays.toString(res));
    }

    //原数组：       [1       2       3       4]
    //左部分的乘积：   1       1      1*2    1*2*3
    //右部分的乘积： 2*3*4    3*4      4      1
    //结果：        1*2*3*4  1*3*4   1*2*4  1*2*3*1
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {//需要初始化为1，不然结果都是0
            res[i] = 1;
        }
        int left = 1, right = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] *= left;//正序乘上左边的积
            left *= nums[i];//更新左边乘积

            res[nums.length - i - 1] *= right;//逆序乘上右边的积
            right *= nums[nums.length - i - 1];//更新右边乘积
        }
        return res;
    }

    //时间复杂度：O(n)，其中 n 是 nums 的长度。
    //空间复杂度：O(n)。
    public static int[] productExceptSelf1(int[] nums) {
        int n = nums.length;

        int[] suf = new int[n];
        suf[n - 1] = 1;
        //定义后缀乘积 suf[i] 表示从 nums[i+1] 到 nums[n−1] 的乘积
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] * nums[i + 1];
        }

        int[] pre = new int[n];
        pre[0] = 1;
        //定义前缀乘积 pre[i] 表示从 nums[0] 到 nums[i−1] 的乘积
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = pre[i] * suf[i];
        }
        return res;
    }

    //优化：不使用额外空间
    //先计算 suf，然后一边计算 pre，一边把 pre 直接乘到 suf[i] 中。最后返回 suf。
    //题目说「输出数组不被视为额外空间」，所以该做法的空间复杂度为 O(1)。此外，这种做法比上面少遍历了一次。
    //时间复杂度：O(n)，其中 n 是 nums 的长度。其中 N 为数组长度，两轮遍历数组 nums ，使用 O(N) 时间
    //空间复杂度：O(1)。
    public static int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] suf = new int[n];
        suf[n - 1] = 1;
        //定义 suf[i] 表示从 nums[i+1] 到 nums[n−1] 的乘积
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] * nums[i + 1];
        }

        int pre = 1;
        for (int i = 0; i < n; i++) {
            // 此时 pre 为 nums[0] 到 nums[i-1] 的乘积，直接乘到 suf[i] 中
            suf[i] *= pre;
            pre *= nums[i];
        }
        return suf;
    }
}
