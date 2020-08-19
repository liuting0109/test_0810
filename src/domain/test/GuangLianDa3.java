package domain.test;

import java.util.Scanner;

/*
你购买了一个机器人，它现在剩下C单位电量，你现在想让它做一些动作愉悦自己。
它可以做n种动作，每种动作最多做一次，
每种动作都有一个固定电量花费ci单位电量，以及这个动作的愉悦度wi。
请在你电量范围内让它做出让你最愉悦的动作。
即做的动作的总电量消耗不能超过C，并使愉悦度之和最大。
（我们将情景简化，电量在开始动作前就要扣除，若电量不足则无法开始作，不存在动作进行到一半的状态）
 * 输入描述
 * 第一行两个以空格隔开的正整数n和C，表示动作数量和机器人剩余电量。
 * 接下来n行，每行两个以空格隔开的浮点数ci和整数wi，代表第i种动作电量消耗以及愉悦度。
 * 输出描述
 * 一个整数，表示愉悦度之和的最大值
 * 样例输入
 * 3 15
 * 5.00 16
 * 9.00 1
 * 8.00 15
 * 样例输出
 * 31
 * 提示
 * 选择第一个和第三个动作，总电量消耗5.00+8.00=13.00<15，总愉悦度31，可以证明这是最优方案。
 * n≤300，C≤30000，0≤c_i≤900000.00，0<w_i≤250
 */
public class GuangLianDa3 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();//n个动作
        int Cost = sc.nextInt();//总电量

        float[] c = new float[n];
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextFloat();
            w[i]= sc.nextInt();
        }

        System.out.println(fun(n, Cost, c, w));
    }

    public static int fun(int n, int Cost, float[] c, int[] w){
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = (int)(c[i]);
        }

        float[] dp = new float[Cost + 1];
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = Cost; j >= temp[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - temp[i]] + w[i]);
            }
        }
        return (int) dp[Cost];
    }
}
