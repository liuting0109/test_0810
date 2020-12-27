package LeetCode;

public class L53 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum = sum > 0 ?sum + nums[i] : nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
