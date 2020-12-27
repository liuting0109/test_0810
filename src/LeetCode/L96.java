package LeetCode;

/**
 * @Author LT
 * @Date 2020/12/27 15:54
 * @Version 1.0
 * @Description
 */
public class L96 {
    /*
    标签：动态规划
    假设 n 个节点存在二叉排序树的个数是 G (n)，令 f(i) 为以 i 为根的二叉搜索树的个数，则
    G(n) = f(1) + f(2) + f(3) + f(4) + ... + f(n)

    当 i 为根节点时，其左子树节点个数为 i-1 个，右子树节点为 n-i，则
    f(i) = G(i-1)*G(n-i)

    综合两个公式可以得到 卡特兰数 公式
    G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)G(n)=G(0)∗G(n−1)+G(1)∗(n−2)+...+G(n−1)∗G(0)
     */
    public int numTrees(int n) {
       /* if (n == 1|| n== 0)return 1;
        int res = 0;
        for (int i = 1; i < n; i++) {//递归
            res += numTrees(i - 1)*numTrees(n - i);
        }
        return res;*/
        //非递归
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1]* dp[i - j];
            }
        }
        return dp[n];
    }
}
