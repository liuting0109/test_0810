package LeetCode;

/**
 * @Author LT
 * @Date 2020/12/12 22:08
 * @Version 1.0
 * @Description
 */
public class L31 {
    /*
        思路:
        从低位挑一个大一点的数，换掉前面的小一点的一个数，实现变大。
        变大的幅度要尽量小。
        像 [3,2,1] 递减的，没有下一个排列，因为大的已经尽量往前排了，没法更大。
        像 [1,5,2,4,3,2] 这种，我们希望它稍微变大。
        从低位挑一个大一点的数，换掉前面的小一点的一个数。
        于是从右往左，寻找第一个比右邻居小的数。（把它换到后面去）
        找到 1 5 (2) 4 3 2 中间这个 2，让它和它身后的一个数交换，轻微变大。
        还是从右往左，寻找第一个比这个 2 微大的数。15 (2) 4 (3) 2，交换，变成 15 (3) 4 (2) 2。
        这并未结束，变大的幅度可以再小一点，仟位变大了，后三位还可以小。
        后三位是递减的，翻转，变成[1,5,3,2,2,4]，它就是[1,5,2,4,3,2]的下一个排列。
         */
    /**
     * 从数组倒着查找，找到nums[i] 比nums[i+1]小的时候，
     * 就将nums[i]跟nums[i+1]到nums[nums.length - 1]当中
     * 找到一个最小的比nums[i]大的元素交换。
     * 交换后，再把nums[i+1]到nums[nums.length-1]排序，就ok了
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;// 向左遍历，i从倒数第二开始是为了nums[i+1]要存在
        while (i >= 0 && nums[i] >= nums[i + 1]){// 寻找第一个小于右邻居的数
            i --;
        }

        if (i >= 0) {// 这个数在数组中存在，从它身后挑一个数，和它换
            int j = nums.length - 1;// 从最后一项，向左遍历
            while (j >= 0 && nums[j] <= nums[i]) {// 寻找第一个大于 nums[i] 的数
                j--;
            }
            swap(nums, i , j);
            reverse(nums, i + 1, nums.length -1);//因为右半部分是有序的，
            return;
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

    //方法2
    public void nextPermutation1(int[] nums) {
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
}
