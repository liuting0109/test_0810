package LeetCode;

/**
 * @Author LT
 * @Date 2020/9/17 18:50
 * @Version 1.0
 * @Description
 */
public class L5 {
    // dp[i][j] 表示 s[i, j] 是否是回文串
    public String longestPalindrome(String s) {
        int nn = 10;
        //String.valueOf(nn).toCharArray();
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]){
                    dp[i][j] = false;
                }else {
                    if (j - i < 3)
                        dp[i][j] = true;
                    else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

            }
        }
        return s;
    }
}
