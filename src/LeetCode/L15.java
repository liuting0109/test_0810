package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15 {
    public static void main(String[] args) {
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4}; //输出 [[-1,-1,2],[-1,0,1]]
//        int[] nums = new int[]{0, 1, 1}; //输出[]
//        int[] nums = new int[]{0, 0, 0};// 输出 [[0,0,0]]
        int[] nums = new int[]{0, 0, 0, 0};// 输出 [[0,0,0]]
        List<List<Integer>> res;
        res = threeSum3(nums);
        System.out.println(res);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //if (nums[0] > 0||nums.length <= 0) return res;//这句特判有问题
        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            //if (nums[i] == nums[i+1]) continue;//这么写不对,会少解
            if (i > 0 && nums[i] == nums[i - 1]) continue;//先计算i-1位置的解，再比较i和i-1位置
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    res.add(temp);
                    while (j < k && nums[j + 1] == nums[j]) j++;//去重，重点理解
                    while (j < k && nums[k - 1] == nums[k]) k--;
                    j++;//不要忘掉
                    k--;
                } else if (nums[i] + nums[j] + nums[k] > 0)
                    k--;
                else j++;
            }
        }
        return res;
    }

    /**
     * 标签：数组遍历
     * 首先对数组进行排序，排序后固定一个数 nums[i]，再使用左右指针指向 nums[i]后面的两端，数字分别为 nums[L] 和 nums[R]，
     * 计算三个数的和 sum 判断是否满足为 0，满足则添加进结果集
     * 如果 nums[i]大于 0，则三数之和必然无法等于 0，结束循环
     * 如果 nums[i] == nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
     * 当 sum == 0 时，nums[L] == nums[L+1] 则会导致结果重复，应该跳过，L++
     * 当 sum == 0 时，nums[R] == nums[R−1] 则会导致结果重复，应该跳过，R−−
     * 时间复杂度：O(n*n)，n 为数组长度
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        if (nums == null || nums.length < 3)
            return null;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        //todo  i < nums.length 错误
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0)
                break;
            int j = i + 1, k = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) continue;//!!不可少，否则输入[[0,0,0],[0,0,0]] 实际输出[[0,0,0],[0,0,0]]，错误
            while (j < k) {
                //写法不对，[0,0,0]应该输出[[0,0,0]]，实际输出[]
//                if (nums[i] + nums[j] + nums[k] == 0
//                        && nums[k] != nums[k - 1]
//                        && nums[j] != nums[j + 1] && (i > 0 && nums[i] != nums[i - 1])) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    k--;
                    j++;
                } else if (nums[i] + nums[j] + nums[k] > 0)
                    k--;
                else
                    j++;
            }
        }
        return res;
    }

    //错误
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        Arrays.sort(nums);
        int k = nums.length - 1;
        for (int i = 0; i < nums.length - 2; i++) {
//            if (nums[i] == nums[i + 1]) continue;//错误 否则输入[0, 0, 0, 0] 输出为空

            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;

            if (nums[i] + nums[j] + nums[k] == 0) {
                res.add(Arrays.asList(nums[i], nums[j], nums[k]));
            } else if (nums[i] + nums[j] + nums[k] < 0) {
                while (j < k && nums[j] == nums[j + 1]) {
                    j++;
                }
                while (j < k && nums[k - 1] == nums[k]) {
                    k--;
                }
                j++;
                if (nums[i] + nums[j] + nums[k] == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }//错误写法  固定i后。j k未相遇便已退出循坏，答案错误
            } else if (nums[i] + nums[j] + nums[k] > 0) {
                while (j < k && nums[j] == nums[j + 1]) {
                    j++;
                }
                while (j < k && nums[k - 1] == nums[k]) {
                    k--;
                }
                k--;
                if (nums[i] + nums[j] + nums[k] == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        Arrays.sort(nums);
        int k = nums.length - 1;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
//            if (nums[i] == nums[i + 1]) continue;//错误 否则输入[0, 0, 0, 0] 输出为空
            int j = i + 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k - 1] == nums[k]) {
                        k--;
                    }
                    j++;
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }
}
