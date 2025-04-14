package LeetCode;

import java.util.HashMap;

public class L560 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySum1(nums, k));
    }

    /** 不适用滑动窗口，因为有负数
     * 滑动窗口针对的情况是，窗口变大或者变小，窗口内的某种性质是单调变化的。
     * 比如这个题，如果 nums[i] 都是正整数的话，那么窗口范围变大时，窗口内和是递增的，窗口范围变小时，窗口内和是递减的。
     * 这种情况下是可以使用滑动窗口的。
     **/
    public static int subarraySum2(int[] nums, int k) {
        int res = 0;
        int left = 0, right = 0, tempSum = 0;
        while (right < nums.length) {
            tempSum += nums[right];
            if (tempSum == k) {
                res++;
            }
            while (tempSum > k && left <= right) {
                tempSum -= nums[left];
                left++;
                if (tempSum == k) {
                    res++;
                }
            }

            right++;
        }
        return res;
    }

    //时间复杂度：O(n)  空间复杂度：O(n)
    public static int subarraySum1(int[] nums, int k) {
        /**
         扫描一遍数组, 使用map记录出现同样的和的次数, 对每个i计算累计和sum并判断map内是否有sum-k
         **/
        int count = 0, pre = 0;
        // key：前缀和，value：key 对应的前缀和的个数
        HashMap<Integer, Integer> map = new HashMap<>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            // 先获得前缀和为 preSum - k 的个数，加到计数变量里
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            // 然后维护 preSumFreq 的定义
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    /**
     * 时间复杂度为 O(n2)  空间复杂度：O(1)
     */
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }
}
