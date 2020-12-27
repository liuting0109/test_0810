package LeetCode;

/**
 * @Author LT
 * @Date 2020/12/12 17:19
 * @Version 1.0
 * @Description
 */
public class L647 {


    //dp
    public int countSubstrings(String s) {
        boolean[][]dp = new boolean[s.length()][s.length()];
        int count = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])){
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

    //方法2
    int num = 0;
    public int countSubstrings2(String s) {
        for (int i = 0; i < s.length(); i++) {
            count(s,i,i);//回文串长度为奇数
            count(s,i,i+1);//回文串长度为偶数
        }
        return num;
    }

    private void count(String s, int start, int end) {
        while (start >= 0&& end < s.length()
                && s.charAt(start) == s.charAt(end)){//中心拓展法
            num++;
            start--;
            end++;
        }
    }
}
