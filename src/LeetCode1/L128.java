package LeetCode1;

import java.util.HashSet;
import java.util.Set;

public class L128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        return 0;
        /*Arrays.sort(nums);
        int res = 1;
        int max = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i] + 1) {
                res++;
                max = Math.max(res, max);
            }
        }
        return max;*/
    }
}
