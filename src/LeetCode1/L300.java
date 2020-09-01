package LeetCode1;

import java.util.Arrays;

public class L300 {
    public static void main(String[] args) {
        int[] arr = new int[]{10,9,2,5,3,7,101,18};
        int res = lengthOfLIS(arr);
        System.out.println(res);
    }
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;
        int[] dp = new int[len];
        Arrays.fill(dp,1);

        for (int i = 1; i < len; i++){
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    //System.out.println(i+" -"+dp[i]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {//找出dp中最大的数
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
