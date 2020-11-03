package LeetCode;

/**
 * @Author LT
 * @Date 2020/9/28 10:03
 * @Version 1.0
 * @Description
 */
/*
   0 1 2 3 4 5(amount)
 1 1 1 1 1 1 1
 2     2 2 3 3
 5           4
 */
public class L518 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        change(5,coins);
    }
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin : coins){
            for (int x = coin; x <= amount; x ++){
                dp[x] = dp[x] + dp[x - coin];
                System.out.print(x +" "+ dp[x]);
                System.out.println();
            }
            /*for (int i = 0; i < amount + 1; i++) {
                System.out.print(i +" "+ dp[i]);
                System.out.println();
            }*/

        }
        System.out.println(dp[amount]);
        return dp[amount];
    }

    public static int change1(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int j = 1; j <= amount; j++) {//枚举金额
            for (int i = 0; i < coins.length; i++) {
                int coin = coins[i];
                if (j < coin) continue;//coin不能大于amount
                dp[j] = dp[j] + dp[j - coin];
            }
        }
        for (int i = 0; i < amount + 1; i++) {
            System.out.println(dp[i]);
        }
        return dp[amount];
    }
 }
