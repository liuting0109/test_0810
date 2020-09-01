package LeetCode1;

public class L581 {
    public int findUnsortedSubarray(int[] nums) {
        /*
        从左到右循环，记录最大值为 max，
        若 nums[i] < max, 则表明位置 i 需要调整, 循环结束，
        记录需要调整的最大位置 i 为 high;
         同理，从右到左循环，记录最小值为 min, 若 nums[i] > min,
         则表明位置 i 需要调整，循环结束，记录需要调整的最小位置 i 为 low.*/
        int len = nums.length;
        int max = nums[0];
        int min = nums[len -1];
        int left = 0, right = 0;
        for (int i = 0; i < len; i++) {
            if (max > nums[i])
                right = i;
            else
                max = nums[i];
            if (min < nums[len - i -1])
                left = len - i -1;
            else
                min = nums[len - i -1];
        }
        //return right - left + 1;//测试用例为[1,2,3,4]结果是1，不符。要特判
        return right - left > 0? right - left + 1: 0;
    }
}
