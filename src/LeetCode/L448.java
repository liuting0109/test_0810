package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LT
 * @Date 2020/12/12 14:19
 * @Version 1.0
 * @Description
 */
public class L448 {
    //将所有正数作为数组下标，置对应数组值为负值。那么，仍为正数的位置即为（未出现过）消失的数字。
  /*
    原始数组：[4,3,2,7,8,2,3,1]
    重置后为：[-4,-3,-2,-7,8,2,-3,-1]
   */
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> res = findDisappearedNumbers1(arr);
        System.out.println(res);
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0){//不可以少
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] +" ");
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                res.add(i+1);
            }
        }
        return res;
    }

    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {//错误。因为数字不止出现一次，注意审题
            nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] +" ");
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                res.add(i+1);
            }
        }
        return res;
    }

}
