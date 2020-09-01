package LeetCode1;

import java.util.Arrays;

public class L354 {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n < 1)
            return 0;
        int max = 1;
        Arrays.sort(envelopes);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]);{
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}