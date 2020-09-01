package domain.test;

public class t58_3 {
    /*剑指offer 第46题
    )0代表a,z代表25,一个数字可以有多少种字母表达方式 ac
     */
    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }
    public static int translateNum (int num) {
        // write code here


        String str = String.valueOf(num);
        int[] dp = new int[str.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1];
            int temp = Integer.parseInt(str.substring(i - 2, i));
            if (temp >= 10 && temp <= 25) {//temp >= 10重点！！！！！！！！
                dp[i] += dp[i - 2];
                System.out.println(dp[i]);
            }
        }
        return dp[str.length()];
    }
}
