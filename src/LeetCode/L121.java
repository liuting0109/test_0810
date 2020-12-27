package LeetCode;


/**
 * @Author LT
 * @Date 2020/12/12 14:50
 * @Version 1.0
 * @Description
 */
public class L121 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        if (prices.length <= 1)return 0;
        int min = prices[0], max = 0;
        //动态规划 前i天的最大收益
        // = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max,prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;

        /*//错误
        int []dp = new int[prices.length + 1];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(prices[i] - prices[j],dp[i] );
            }
        }
        return dp[prices.length - 1];*/
    }
}
