package LeetCode;

import java.util.HashMap;

public class L560 {
    public int subarraySum1(int[] nums, int k) {
        /**
         扫描一遍数组, 使用map记录出现同样的和的次数, 对每个i计算累计和sum并判断map内是否有sum-k
         **/
        int count = 0, pre = 0;
        // key：前缀和，value：key 对应的前缀和的个数
        HashMap<Integer, Integer> map = new HashMap<>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            // 先获得前缀和为 preSum - k 的个数，加到计数变量里
            if (map.containsKey(pre - k)){
                count += map.get(pre - k);
            }
            // 然后维护 preSumFreq 的定义
            map.put(pre, map.getOrDefault(pre, 0) +1);
        }
        return count;
    }
    public int subarraySum(int[] nums, int k) {
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
