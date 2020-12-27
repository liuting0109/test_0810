package LeetCode;

/**
 * @Author LT
 * @Date 2020/12/27 15:06
 * @Version 1.0
 * @Description
 */
public class L338 {
    public static void main(String[] args) {
        int[] res = countBits(8);
        for (int i = 0; i <= 8; i++) {
            System.out.print(res[i]+" ");
        }
    }
    /*奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1。
        偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。
         */
    //细节有错
    public static int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;//错误，因为会越界
        for (int i = 2; i <= num; i++) {
            if (i % 2 == 0){
                dp[i] = dp[i / 2];
            }else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp;
    }

    public static int[] countBits2(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;

        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0){
                dp[i] = dp[i / 2];
            }else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp;
    }
}
