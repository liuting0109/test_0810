package LeetCode;

/**
 * @Author LT
 * @Date 2020/12/12 15:04
 * @Version 1.0
 * @Description
 */
public class L62 {
    public static void main(String[] args) {
        int res = uniquePaths(10,10);
        System.out.println(res);
    }
    //方法1 dp
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    //方法2 数学
    public static int uniquePaths(int m, int n) {
        /**法2 数据类型换成double也不行，数据还是会溢出
         * 机器人一定会走m+n-2步，
         * 从m+n-2中挑出m-1步向下走
         * 即C（（m+n-2），（m-1））。
         */
        return (int) C(m + n - 2,Math.max(m -1,n -1));
    }
    //实现了数学中的组合方法C(n,r)即 n!/(n-r)!r!
    public static double C(int n, int r){
        return factorial(n)/(factorial(n-r)*factorial(r));
    }

    public static double factorial(int n){//阶乘
        double res = 1;
        for (int i = 2; i <= n; i++) {
            res*= i;
        }
        return res;
    }
}
