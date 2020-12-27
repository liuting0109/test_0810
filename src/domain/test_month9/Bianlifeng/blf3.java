package domain.test_month9.Bianlifeng;

import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/18 17:13
 * @Version 1.0
 * @Description
 */
/*
便利店有价格不等的多种商品，假定价格都是正整数且每种商品的数量都是无限多的；用户手上有特定金额的钱，计算有多少种不同方式可以把钱花光。
输入描述
public int buy(int money, int[] items)
说明：
money：用户拥有的总金额
items：商品价格数组
输出描述
返回：购物组合数量

样例输入
5
1,2,5
样例输出
4

提示
解释：
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
 */
public class blf3 {
    public static void main(String[] args) {
/*        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        String temp = sc.next();//是next nextline错误
        //System.out.println(temp);
        //String str = sc.nextLine();、、错误
        String[] arr = temp.split(",");//注意输入的写法！！！！
        int[] coins  = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            coins[i] = Integer.valueOf(arr[i]);
        }
        //int money = Integer.valueOf(arr[0]);
        //System.out.println(money);
        System.out.println(buy(money, coins));
        //System.out.println(str);*/

        int[] coins = {1,2,5};
        int res = buy(5, coins);
        System.out.println(res);

    }

    //DP[i] = DP[i] + DP[i-k] , k = 1, 2, 5;
    public static int buy(int money, int[] coins){
        int res = 0;
        int len = coins.length;
        int[] dp = new int[money + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= money; j++) {
                dp[j] = dp[j] + dp[j -coins[i]];

            }
        }
        return dp[money];
    }


}
