package LeetCode1;


public class L198 {
    public int rob(int[] nums) {
        if (nums.length <= 1)
            return nums.length > 0? nums[0]:0;
        int[] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {//动态规划
            res[i] = Math.max(res[i - 1], nums[i] + res[i - 2]);
        }
        return res[nums.length - 1];
    }
}
