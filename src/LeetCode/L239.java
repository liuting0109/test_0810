package LeetCode;

public class L239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0||nums.length == 0)
            return new int[0];
        int[] res = new int[nums.length- k +1];
        for (int i = 0; i <= nums.length - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;
    }
    public int[] maxSlidingWindow1(int[] nums, int k){
        if (k == 0||nums.length == 0)
            return new int[0];
        int[] res = new int[nums.length- k +1];
        int j = 0;
        int maxIndex = -1;
        for (int i = 0; i <= nums.length - k; i++) {
            if(i <= maxIndex && maxIndex < i + k){
                if (nums[maxIndex] <= nums[i + k -1]){
                    maxIndex = i + k -1;
                }
            }else {
                maxIndex = i;
                for (int m = i; m <= i + k - 1; m++) {
                    if (nums[maxIndex] < nums[m])
                        maxIndex = m;
                }
            }
            res[j ++] = nums[maxIndex];
        }
        return res;
    }

}
