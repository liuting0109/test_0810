package LeetCode;

import java.util.Arrays;

/**
 * @Author LT
 * @Date 2020/12/26 17:29
 * @Version 1.0
 * @Description
 */
public class L169 {
    //正解
    public int majorityElement1(int[] nums) {
        int count = 1;
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0){
                temp = nums[i];
                count ++;
            }else {
                if (temp == nums[i]){
                    count ++;
                }else {
                    count --;
                }
            }
        }
        return temp;
    }
    //看看自己错在那，错解
    public int majorityElement(int[] nums) {
        int count = 0;//错
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0){
                temp = nums[i];//错
            }else {
                if (temp == nums[i]){
                    count ++;
                }else {
                    count --;
                }
            }
        }
        return temp;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
