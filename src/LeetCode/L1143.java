package LeetCode;

/**
 * @Author LT
 * @Date 2020/9/19 20:55
 * @Version 1.0
 * @Description
 */
//最长公共子序列
public class L1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() == 0 || text2.length() == 0) return 0;
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];
        //由于空串的时候肯定最长公共子串为0，所以直接从dp[1][1]开始遍历
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //s1[i] == s2[j],则表示在以当前结果就等于之前没进来字符串的结果+1.
                if (text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][ j - 1] + 1;

                }else {//s1[i] != s2[j]则表示至少有一个不在（要么s1[i]不在，要么s2[j]不在，
                    // 或者都不在）。，所以当前结果就相当于之前结果的中最大的那一个
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
