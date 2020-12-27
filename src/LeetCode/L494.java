package LeetCode;


public class L494 {
    public int findTargetSumWays(int[] nums, int S) {
        /**不太会
         * P是正子集，N为负， p-n = s;
         * p-n+p+n = 2p = s+(p+n) = s+sum(nums);
         * p = 1/2 *(s+sum(nums))
         */
        int sum = 0;
        for (int n: nums){
            sum+=n;
        }
        if (sum < S) return 0;
        else if ((sum +S)% 2 ==1) return 0;

        int target = (sum +S)/2;
        //01背包问题
        int[] dp = new int[target+1];
        dp[0] = 1;//别忘记
        //dp[i]代表的含义是从nums中取数相加和为i时有多少种取法。
        // i=0时，就是说从nums中取数相加和为0时有几种取法，
        // 只有一种即一个数也不取，所以dp[0]=1
        for (int n: nums){
            for (int i = target; i >= n; i--) {
                dp[i] += dp[i - n];
            }
        }
        return dp[target];
    }
}
