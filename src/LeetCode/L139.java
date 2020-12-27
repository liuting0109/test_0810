package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LT
 * @Date 2020/12/6 19:57
 * @Version 1.0
 * @Description
 */
public class L139 {
    //dp[i]=dp[j] && check(s[j..i−1])
    /*public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] memo = new boolean[n + 1];
        memo[0] = true;
        for (int i = 1; i <= n; i++) {

        }
    }*/
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        boolean res = wordBreak(s, wordDict);
        System.out.println(res);
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        // 可以类比于背包问题
        int n = s.length();
        // memo[i] 表示 s 中以 i - 1 结尾的字符串是否可被 wordDict 拆分
        boolean[] memo = new boolean[n + 1];
        memo[0] = true;//空子集也算子集，所以true；dp动态规划
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (memo[j] && wordDict.contains(s.substring(j, i))){
                    memo[i] = true;
                    System.out.println(i);
                    break;
                }
            }
        }
        return memo[n];
    }
}
