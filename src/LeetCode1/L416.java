package LeetCode1;

public class L416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n: nums){
            sum+= n;
        }
        if (sum % 2 != 0) return false;// 特判：如果是奇数，就不符合要求,无法分割数组
        int len = nums.length;
        if (len == 0)return false;
        int target = sum/2;
        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        boolean[][] dp = new boolean[len][target + 1];
        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target){
            dp[0][nums[0]] = true;
        }

        // 再填表格后面几行
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target ; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i] <= j){
                    dp[i][j] = dp[i - 1][j] ||dp[i - 1][j- nums[i]];
                }
                if (dp[i][target]){
                    return true;
                }
            }
        }
        return dp[len - 1][target];
    }
    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int n: nums){
            sum+= n;
        }
        if (sum % 2 != 0) return false;// 特判：如果是奇数，就不符合要求,无法分割数组
        int len = nums.length;
        if (len == 0)return false;
        int target = sum/2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        if (nums[0] <=target){
            dp[nums[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j =target; nums[i] <= j; j--) {
                if (dp[target]){
                    return true;
                }
                dp[j] = dp[j]|| dp[j- nums[i]];
            }
        }
        return dp[target];
    }
}
