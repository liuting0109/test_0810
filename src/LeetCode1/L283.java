package LeetCode1;

public class L283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[count++] = nums[i];
            }
        }
        for (int i = count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
