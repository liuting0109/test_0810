package domain.test_month9.ZhenAi;

import com.sun.org.apache.regexp.internal.REUtil;

/**
 * @Author LT
 * @Date 2020/9/11 21:11
 * @Version 1.0
 * @Description
 */
public class ZhenAi2 {
    public static void main(String[] args) {

        int [] arr = {20,30,20};
        System.out.println(saveZhenaiCoin(arr));
    }
    public static int saveZhenaiCoin (int[] grid) {
        // write code here
        int len = grid.length;
        int [] dp = new int[len + 1];
        //int res = 0;
        dp[0] = grid[0];
        for (int i = 0; i < len; i++) {
            dp[i] = grid[i];
        }
        dp[0] = grid[0];
        dp[1] = Math.min(dp[1],dp[0]);
        //dp[2] = dp[2] + Math.min(dp[1],dp[0]);
        for (int i = 2; i < len + 1; i++) {
            dp[i] = dp[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        int res1 =dp[len];
        int res2 = help(grid);
        System.out.println(res2);
        return res1 < res2 ? res1:res2;
        //return dp[len];
    }
    public static int help(int[] grid){
        int len = grid.length;
        int [] dp = new int[len + 1];
        //int res = 0;
        //dp[0] = grid[0];
        for (int i = 0; i < len - 1; i++) {
            dp[i] = grid[i + 1];
        }
        dp[0] = grid[0];
        dp[1] = Math.min(dp[1],dp[0]);
        //dp[2] = dp[2] + Math.min(dp[1],dp[0]);
        for (int i = 2; i < len + 1; i++) {
            dp[i] = dp[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        int res1 =dp[len];

        return dp[len];
    }
}
