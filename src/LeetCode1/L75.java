package LeetCode1;

public class L75 {
    public void sortColors(int[] nums) {
        int p0 = 0,curr = 0;
        int p2 = nums.length - 1;
        int tmp;
        while (curr <= p2){
            if (nums[curr] == 0){
                // 交换第 p0个和第curr个元素
                // i++，j++
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            }else if (nums[curr] == 2) {
                // 交换第k个和第curr个元素
                // p2--
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            }
            else curr++;
        }
    }
}
