package LeetCode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class L239 {
    //滑动窗口最大值
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;//输出[3,3,5,5,6,7]
        System.out.println(Arrays.toString(maxSlidingWindow1(nums, k)));
    }

    //暴力遍历
    // 使用 O(k) 的时间遍历其中的每一个元素，找出其中的最大值。
    // 对于长度为 n 的数组 nums 而言，窗口的数量为 n−k+1，因此该算法的时间复杂度为 O((n−k+1)k)=O(nk)，
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0 || nums.length == 0)
            return new int[0];
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;
    }

    //优先队列 单调队列套路
    //右边入（元素进入队尾，同时维护队列单调性）
    //左边出（元素离开队首）
    //记录/维护答案（根据队首）
//    时间复杂度：O(n)，其中 n 为 nums 的长度。由于每个下标至多入队出队各一次，所以二重循环的循环次数是 O(n) 的。
//    空间复杂度：O(min(k,U))，其中 U 是 nums 中的不同元素个数（本题至多为 20001）。
//    双端队列至多有 k 个元素，同时又没有重复元素，所以也至多有 U 个元素，所以空间复杂度为 O(min(k,U))。返回值的空间不计入
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // 1. 右边入
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast(); // 维护 q 的单调性
            }
            q.add(i);// 注意保存的是下标，这样下面可以判断队首是否离开窗口

            // 2. 左边出
            int left = i - k + 1;// 窗口左端点
            if (q.getFirst() < left) {// 队首离开窗口
                q.removeFirst();
            }

            // 3. 在窗口左端点处记录答案
            if (left >= 0) {
                // 由于队首到队尾单调递减，所以窗口最大值就在队首
                res[left] = nums[q.getFirst()];
            }
        }
        return res;
    }

    //此算法已超时
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if (k == 0 || nums.length == 0)
            return new int[0];
        int[] res = new int[nums.length - k + 1];
        int j = 0;
        int maxIndex = -1;
        for (int i = 0; i <= nums.length - k; i++) {
            if (i <= maxIndex && maxIndex < i + k) {
                if (nums[maxIndex] <= nums[i + k - 1]) {
                    maxIndex = i + k - 1;
                }
            } else {
                maxIndex = i;
                for (int m = i; m <= i + k - 1; m++) {
                    if (nums[maxIndex] < nums[m])
                        maxIndex = m;
                }
            }
            res[j++] = nums[maxIndex];
        }
        return res;
    }

}
