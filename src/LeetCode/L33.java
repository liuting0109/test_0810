package LeetCode;

public class L33 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len -1;
        while (left <= right){//是left <= right，而不是left<right
            int mid = (left + right)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < nums[right]){//右半段有序
                if (nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }else {//左半段有序
                if (nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
