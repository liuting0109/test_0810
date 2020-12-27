package LeetCode;

import java.util.Arrays;

public class L322 {
    public int coinChange(int[] coins, int amount) {
        /**
         * dp,对于任意金额j,dp[j] = min(dp[j],dp[j-coin]+1),如果j-coin存在的话.
         */
        if (coins.length == 0){
            return -1;
        }
        // dp表示的凑成总金额为n所需的最少的硬币个数
        int[] dp = new int[amount + 1];
        //给memo赋初值，最多的硬币数就是全部使用面值1的硬币进行换
        // amount + 1 是不可能达到的换取数量，于是使用其进行填充
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] == amount + 1? -1 :dp[amount];
    }
}
