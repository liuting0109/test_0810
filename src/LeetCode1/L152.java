package LeetCode1;

public class L152 {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0){
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            //由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max,imax);
        }
        return max;
    }
}
