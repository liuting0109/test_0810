package LeetCode1;

public class L287 {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1, res=0;
        while (left <= right){
            int mid = (left + right)/2;
            int count = 0;
            for (int num: nums){
                if (num <= mid)
                    count++;
            }
            // 根据抽屉原理，严格小于 4 的数的个数如果大于等于 4 个，
            // 此时重复元素一定出现在 [1, 3] 区间里
            if (count <= mid){
                left = mid + 1;
            }else {
                right = mid - 1;
                res = mid;
            }
        }
        return res;
    }
}
