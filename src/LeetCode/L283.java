package LeetCode;

/**
 * @Author LT
 * @Date 2020/12/26 17:11
 * @Version 1.0
 * @Description 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class L283 {

    public static void main(String[] args) {
        //{1}  {1,0}  {0,1,0,3,12}
        int[] nums = {1,0};
        moveZeroes4(nums);
        System.out.println(nums);
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    //双指针
    public static void moveZeroes2(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

    //报错
    public static void moveZeroes3(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int j = 0;
        //case 1： {1} -> 输出为{0}报错  case 2: [1,0]-> 输出为[0,0]报错
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                nums[i] = 0;
                j++;
            }
        }
    }

    //bingo
    public static void moveZeroes4(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0;
        // case 2: [1,0]-> 输出为[0,0] 正确？？!! todo
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = 0;
                nums[j] = temp;
                j++;
            }
        }
    }

}
