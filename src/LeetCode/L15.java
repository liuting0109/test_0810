package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> res = new ArrayList<>();
        res = threeSum(nums);
        System.out.println(res);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //if (nums[0] > 0||nums.length <= 0) return res;//这句特判有问题
        if (nums == null ||nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            //if (nums[i] == nums[i+1]) continue;//这么写不对,会少解
            if (i > 0 && nums[i] == nums[i - 1]) continue;//先计算i-1位置的解，再比较i和i-1位置
            int j = i+1, k = nums.length - 1;
            while (j < k){
                if (nums[i] + nums[j] +nums[k] == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    res.add(temp);
                    while (j < k && nums[j+1] == nums[j]) j++;//去重，重点理解
                    while (j < k && nums[k-1] == nums[k])k--;
                    j++;//不要忘掉
                    k--;
                }else if (nums[i] + nums[j] +nums[k] > 0)
                    k--;
                else j++;
            }
        }
        return res;
    }
}
