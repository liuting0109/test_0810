package domain.test_month9.OKCoin;

/**
 * @Author LT
 * @Date 2020/9/17 14:45
 * @Version 1.0
 * @Description
 */
//写二分查找
public class OKCoin1 {
    public int search (int[] nums, int target) {
        // write code here
        int left = 0; int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
