package LeetCode;

public class L53 {
    //最大子数组和 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    //子数组是数组中的一个连续部分。
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};//输出6 连续子数组 [4,-1,2,1] 的和最大，为 6 。
        int[] nums1 = {5, 4, -1, 7, 8};//输出23 连续子数组 5,4,-1,7,8 的和最大，为 23 。
        System.out.println(maxSubArray1(nums1));
    }

    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum = sum > 0 ? sum + nums[i] : nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }

    //方法一：动态规划
    //假设 nums 数组的长度是 n，下标从 0 到 n−1。
    //我们用 f(i) 代表以第 i 个数结尾的「连续子数组的最大和」，
    //因此我们只需要求出每个位置的 f(i)，然后返回 f 数组中的最大值即可。
    // 那么我们如何求 f(i) 呢？我们可以考虑 nums[i] 单独成为一段还是加入 f(i−1) 对应的那一段，
    // 这取决于 nums[i] 和 f(i−1)+nums[i] 的大小，我们希望获得一个比较大的，于是可以写出这样的动态规划转移方程：
    //f(i)=max{f(i−1)+nums[i],nums[i]}
    //即用一个 f 数组来保存 f(i) 的值，用一个循环求出所有 f(i)。
    // 考虑到 f(i) 只和 f(i−1) 相关，于是我们可以只用一个变量 pre 来维护对于当前 f(i) 的 f(i−1) 的值是多少，
    // 从而让空间复杂度降低到 O(1)，这有点类似「滚动数组」的思想。
    //时间复杂度：O(n)，其中 n 为 nums 数组的长度。我们只需要遍历一遍数组即可求得答案。
    //空间复杂度：O(1)。我们只需要常数空间存放若干变量。
    public static int maxSubArray1(int[] nums) {
        int pre = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
//            pre = Math.max(pre, pre+nums[i]);//错误
            pre = Math.max(nums[i], pre + nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }
}
