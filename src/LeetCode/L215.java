package LeetCode;

public class L215 {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int target = len - k;
        while (true){
            int index = partition(nums, left, right);
            if (index == target)return nums[index];
            else if (index < target) left = index + 1;
            else right = index - 1;
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];

        // 使用双指针的办法找到切分元素的位置。将等于 pivot 的元素分散到两边
        // [left, lt) <= pivot
        // (rt, right] >= pivot
        int lt = left + 1;
        int rt = right;
        while (true){
            while (lt <= rt && nums[lt] < pivot)
                lt++;
            while (lt <= rt && nums[rt] > pivot)
                rt--;
            if (lt > rt)break;
            swap(nums, lt, rt);
            lt++;
            rt--;
        }
        swap(nums, left,rt);
        return rt;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
