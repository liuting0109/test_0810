package LeetCode;

/**
 * @Author LT
 * @Date 2020/9/17 18:50
 * @Version 1.0
 * @Description
 */
public class L5 {
    public static void main(String[] args) {
        String s = "babad";
        String res = longestPalindrome(s);
        System.out.println(res);
    }
    // dp[i][j] 表示 s[i, j] 是否是回文串
    public static String longestPalindrome(String s) {
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

    public static String longestPalindrome1(String s) {
        //方法3：中心扩散法
        int len = s.length();
        if (len < 2) return s;
        int maxLen = 1;
        String res = s.substring(0,1);
        // 中心位置枚举到 len - 2 即可
        for (int i = 0; i < len - 1; i++) {
            String oddStr = centerSpread(s,i,i);
            String evenStr = centerSpread(s,i,i+1);
            String tempStr = oddStr.length() >
                    evenStr.length()?oddStr : evenStr;
            if (tempStr.length() > maxLen){
                maxLen = tempStr.length();
                res = tempStr;
            }
        }
        return res;

        //方法二：动态规划
        /**
         * dp[i][j] 表示子串 s[i..j] 是否为回文子串，
         * 这里子串 s[i..j] 可以取到 s[i] 和 s[j]。
         dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]
         s[i + 1..j - 1] 只有 1 个字符显然是回文；
         s[i + 1..j - 1] 为空串，一定是回文子串。
         因此，在 s[i] == s[j] 成立和 j - i < 3 的前提下
         ，dp[i][j] = true，否则才执行状态转移。
         */
        /*int len = s.length();
        if (len < 2) return s;
        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean dp[][] = new boolean[len][len];
        char[] chars = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]){
                    dp[i][j] = false;
                }else {
                    if (j - i  < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // dp[i][j] == true表示子串 s[i..j] 是回文
                // ，此时记录回文长度和起始位
                if (dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin +maxLen);*/

        //暴力法
 /*       int len = s.length();
        if (len < 2) return s;
        int maxLen = 1;
        int begin = 0;
        // s.charAt(i) 每次都会检查数组下标越界，因此先转换成字符数组
        char[] chars = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && valid(chars, i, j)){
                    maxLen = j- i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);*/
    }

    private static String centerSpread(String s, int left, int right) {
        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
        int len = s.length();
        int i= left, j = right;
        while (i >= 0 && j < len){
            if (s.charAt(i) == s.charAt(j)){
                i--;
                j++;
            }else
                break;
        }
        return s.substring(i + 1, j);
    }

    //验证子串 s[left..right] 是否为回文串
    private static boolean valid(char[] chars, int i, int j){
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
