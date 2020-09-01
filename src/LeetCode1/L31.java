package LeetCode1;

public class L31 {
    public void nextPermutation(int[] nums) {
        /**
         * 从数组倒着查找，找到nums[i] 比nums[i+1]小的时候，
         * 就将nums[i]跟nums[i+1]到nums[nums.length - 1]当中
         * 找到一个最小的比nums[i]大的元素交换。
         * 交换后，再把nums[i+1]到nums[nums.length-1]排序，就ok了
         */
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i]< nums[i + 1]){//找到要交换的i位置
                int j = nums.length - 1;
                //找到一个最小的比nums[i]大的元素交换。
                //因为右边有序，所以从右往左遍历
                for (; j>i && nums[j] <= nums[i]; j--);
                swap(nums, i, j);
                reverse(nums, i + 1, nums.length -1);//因为右半部分是有序的，
                //所以翻转下数组右半部分即可。
                //Arrays.sort(nums,i + 1, nums.length);
                return;
            }
        }
        reverse(nums, 0 ,nums.length - 1);
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int low, int high){
        while (low < high){
            swap(nums, low ++, high --);
        }
    }
}
