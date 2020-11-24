package JZ;
/*
请实现一个函数用来匹配包括'.'和'*'的正则表达式。
模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 在本题中，匹配是指字符串的所有字符匹配整个模式。
 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class JZ52 {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return mathHelp(str,  strIndex, pattern, patternIndex);
    }

    /*
    而当模式中的第二个字符是“*”时：
1、模式后移2字符，相当于x*被忽略；
2、字符串后移1字符，模式后移2字符；
3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
情况2可以被情况1和情况3包含。执行一次情况3，再执行一次情况1，就相当于情况2。
     */
    private boolean mathHelp(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length & patternIndex == pattern.length)
            return true;
        //pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*'){
            if (strIndex != str.length && pattern[patternIndex] == str[strIndex] ||
                    (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return mathHelp(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符
                        ||mathHelp(str, strIndex + 1, pattern, patternIndex + 2)//视为模式匹配1个字符
                        ||mathHelp(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
            }else {
                return mathHelp(str, strIndex, pattern, patternIndex + 2);
            }
        }

        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if (strIndex != str.length && pattern[patternIndex] == str[strIndex] ||
                (pattern[patternIndex] == '.' && strIndex != str.length))
            return mathHelp(str, strIndex + 1, pattern, patternIndex + 1);

        return false;
    }

    public class Solution {
        public boolean match(char[] str, char[] pattern) {

            int m = str.length, n = pattern.length;
            boolean[][] dp = new boolean[m + 1][n + 1];

            dp[0][0] = true;
            for (int i = 1; i <= n; i++)
                if (pattern[i - 1] == '*')
                    dp[0][i] = dp[0][i - 2];

            for (int i = 1; i <= m; i++)
                for (int j = 1; j <= n; j++)
                    if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
                        dp[i][j] = dp[i - 1][j - 1];
                    else if (pattern[j - 1] == '*')
                        if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
                            dp[i][j] |= dp[i][j - 1]; // a* counts as single a
                            dp[i][j] |= dp[i - 1][j]; // a* counts as multiple a
                            dp[i][j] |= dp[i][j - 2]; // a* counts as empty
                        } else
                            dp[i][j] = dp[i][j - 2];   // a* only counts as empty

            return dp[m][n];
        }
    }
}
