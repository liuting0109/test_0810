package domain.test.Tiger;

import java.util.ArrayList;
import java.util.Arrays;
/*
给定N支股票的价格和经理拥有的金钱m，经理可以选择买和不买。输出该经理最终花光m的所有组合

输入：[3,8,6], 14
输出：[[6,8]]
 */
public class Tiger2 {
    public static void main(String[] args) {
        int[] arr = {3,8,6};
        System.out.println(combinationSum(arr, 14));
    }
    public static ArrayList<ArrayList<Integer>> combinationSum (int[] prices, int m) {
    // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(prices);
        if (m < prices[0])
            return res;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] == m) {
                res.add(new ArrayList<>(prices[i]));
            } else {
                for (int j = i + 1; j < prices.length; j++) {
                    if (prices[i] + prices[j] == m) {
                        ArrayList temp = new ArrayList();
                        temp.add(prices[i]);
                        temp.add(prices[j]);
                        res.add(temp);
                    } else {
                        for (int k = j + 1; k < prices.length; k++) {
                            if (prices[i] + prices[j] + prices[k] == m) {
                                ArrayList temp = new ArrayList();
                                temp.add(prices[i]);
                                temp.add(prices[j]);
                                temp.add(prices[k]);
                                res.add(temp);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
