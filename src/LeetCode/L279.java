package LeetCode;

/**
 * @Author LT
 * @Date 2020/12/11 23:16
 * @Version 1.0
 * @Description
 */
public class L279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;// 最坏的情况就是每次+1
            for (int j = 1; j * j <= i ; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
