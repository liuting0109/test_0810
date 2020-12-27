package LeetCode;

public class L221 {
    public int maximalSquare(char[][] matrix) {
        /**
         dp[i][j]表示以第i行第j列为右下角所能构成的最大正方形边长, 则递推式为:
         dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]);

            i-1,j-1    i-1,j
             i,j-1     i j

         **/
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        //int m = matrix.length, n = matrix[0].length;//错误，不可以同时初始化，因为m=0的时候，n会出问题
        int max = 0;
        int [][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] =='1'){
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
