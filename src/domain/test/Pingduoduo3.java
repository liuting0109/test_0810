package domain.test;

import java.util.Scanner;
/*
4 4
-1 -1
1 -1
-1 1
6 6
输出6
给定n个物品和空间为m的背包，每个物品有对应的体积和价值，
体积和价值可以为负数，求可装进背包的最大价值
 */
public class Pingduoduo3 {
    static int []dp=new int[1000005];
    static int []c=new int[500005];
    static int []v=new int[500005];

    public static void main(String[] args)
    {
        Scanner S=new Scanner(System.in);
        int n=S.nextInt(),m=S.nextInt(),k=20005;
        for(int i=0;i<k;i++)
            dp[i]=-10000000;
        for(int i=1;i<=n;i++)
        {
            int w=S.nextInt(),v=S.nextInt();
            if(w<0)
            {
                for(int j=0;j<k+m+w;j++)
                    dp[j]=Math.max(dp[j],dp[j-w]+v);
            }
            else
            {
                for(int j=k+m;j>=w;j--)
                    dp[j]=Math.max(dp[j],dp[j-w]+v);
            }
        }
        int ans=0;
        for(int i=k-5;i<=k+m;i++)
            ans=Math.max(ans,dp[i]);
        System.out.println(ans);
    }


}
