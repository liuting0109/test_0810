package LeetCode1;

import java.util.Arrays;

public class L168 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
