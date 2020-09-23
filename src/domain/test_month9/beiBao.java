package domain.test_month9;

import java.util.List;

public class beiBao {
    public static void main(String[] args) {
        int[][] arr = {{3,4},{4,5},{7,10},{8,11},{9,13}};
        System.out.println(KnapsackDP());
    }

    /*
    01背包问题的定义：
   有N种物品和一个容量为V的背包，每种物品只能装1件。
   第i种物品的费用是v，价值是w。
   求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
     */
    public static int KnapsackDP(){

        int[] weight = {0,3,4,5};//重量
        int[] values =  {0,4,5,2};//价格

        int n = weight.length;
        int max = 10;          //最大载重
        //创建二维数组，实现所有情况:横向以此是背包载重，纵向是物品列表,将每次最优结果填充到该数组中
        int[][] maxValue = new int[n + 1][max + 1];

        for (int i = 0; i <= max; i++) {
            maxValue[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            maxValue[i][0] = 0;
            for (int w = 1; w <= max; w++){
                if(weight[i - 1] <= w){
                    if (values[i - 1] + maxValue[i - 1][max - weight[i - 1]] > maxValue[i - 1][w]){
                        maxValue[i][w] = values[i - 1] + maxValue[i - 1][max - weight[i - 1]];
                    }else {
                        maxValue[i][w] = maxValue[i - 1][w];
                    }
                }else {
                    maxValue[i][w] = maxValue[i - 1][w];
                }
            }
        }
        return maxValue[n][max];
    }
}
