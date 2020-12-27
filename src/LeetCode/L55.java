package LeetCode;

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
/*
如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点。
可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新。
如果可以一直跳到最后，就成功了。
 */
    public boolean canJump1(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max)
                return false;
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}
