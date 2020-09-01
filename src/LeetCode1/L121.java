package LeetCode1;

public class L121 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)return 0;
        int min = prices[0], max = 0;
        //动态规划 前i天的最大收益
        // = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max,prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
/*        int temp = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                temp = Math.max(temp,prices[j] - prices[i]);
            }
        }
        return temp;*/
    }
}
