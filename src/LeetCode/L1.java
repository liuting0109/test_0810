package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author LT
 * @Date 2020/9/11 10:51
 * @Version 1.0
 * @Description 两数之和
 */
public class L1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] res = twoSum2(nums, 9);
        System.out.println(res[0] + " " + res[1]);
    }

    //空间换时间  时间复杂度：N  空间：N
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }

    //暴力解法 时间复杂度：N*N  空间复杂度：O(1)
    public static int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return res;
    }
}
