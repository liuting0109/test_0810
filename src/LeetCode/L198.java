package LeetCode;


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

    public int rob2(int[] nums){
        if (nums.length <= 1)
            return nums.length > 0? nums[0]:0;
        int [] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        //dp[1] = nums[1];//错误
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {//动态规划
            //dp[i] = Math.max(dp[i] + dp[i - 2], dp[i - 1]);//写错了
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

}
