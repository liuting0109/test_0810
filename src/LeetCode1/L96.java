package LeetCode1;

public class L96 {
    public int numTrees(int n) {
       /* if (n == 1|| n== 0)return 1;
        int res = 0;
        for (int i = 1; i < n; i++) {//递归
            res += numTrees(i - 1)*numTrees(n - i);
        }
        return res;*/
        //非递归
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1]* dp[i - j];
            }
        }
        return dp[n];
    }
}
