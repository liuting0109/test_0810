package LeetCode;

/**
 * @Author LT
 * @Date 2020/12/7 22:18
 * @Version 1.0
 * @Description
 */
public class L91 {
    public static void main(String[] args) {
        String s = "11102";
        System.out.println(numDecodings(s));
    }
    public static int numDecodings(String s) {
        int len = s.length();
        if (len == 0)
            return 0;
        if (s.charAt(0) == '0') return 0;
        int[] dp = new int[len + 1];
        /*
        int[] arr = new int[len + 1];

        for (int i = 0; i < len; i++) {
            arr[i] = Integer.valueOf(s.charAt(i)) - '0';//7又忘了 - ‘0’了！！！
        }
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 0; i < len - 1; i++) {
            if (arr[i] * 10 + arr[i + 1] <= 26){
                dp[i] = dp[i - 1] + 2;
            }else {
                dp[i] = dp[i - 1] + 1;
            }
        }*/
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            dp[i + 1] = s.charAt(i) == '0'? 0 :dp[i];
            if (i > 0 && (s.charAt(i - 1) == '1' ||
                    (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))){
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[len];
    }
}
