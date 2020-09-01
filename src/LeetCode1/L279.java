package LeetCode1;

public class L279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏的情况就是每次+1
            for (int j = 1; i - j*j >= 0; j++) {//是i - j*j >= 0，noti - j*j > 0
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1); // 动态转移方程
            }
        }
        return dp[n];
    }
}
