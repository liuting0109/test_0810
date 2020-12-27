package LeetCode;

/**
 * @Author LT
 * @Date 2020/12/26 17:11
 * @Version 1.0
 * @Description
 */
public class L283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    //双指针
    public void moveZeroes2(int[] nums) {
        if(nums==null) {
            return;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}
