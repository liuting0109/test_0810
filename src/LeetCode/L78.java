package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LT
 * @Date 2020/12/6 20:20
 * @Version 1.0
 * @Description
 */
public class L78 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
    /*
    开始假设输出子集为空
    遍历数组，对于数组中的每一个数，每一步向输出子集中的所有子集添加这个整数，并生成新的子集
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int all = res.size();
            for (int j = 0; j < all; j++) {
                List<Integer> temp = new ArrayList<>(res.get(j));
                System.out.println(nums[i]);
                temp.add(nums[i]);
                System.out.println(temp);
                res.add(temp);
            }
        }
        return res;
    }
}
