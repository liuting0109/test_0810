package LeetCode1;

public class L55 {
    public boolean canJump(int[] nums) {
        /**
         * 如果所有元素都不为0， 那么一定可以跳到最后；
         * 从后往前遍历，如果遇到nums[i] = 0，就找i前面的元素j，
         * 使得nums[j] > i - j。如果找不到，则不可能跳跃到num[i+1]，返回false。
         */
        int n = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= n){
                n = 1;
            }else {
                n++;
            }
            if (i == 0 && n > 1){
                return false;
            }
        }
        return true;
    }
}
