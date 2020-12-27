package LeetCode;

/**
 * @Author LT
 * @Date 2020/12/26 17:38
 * @Version 1.0
 * @Description
 */
public class L136 {
    //虽然ac,但是不太对
    public int singleNumber(int[] nums) {
        int res  = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
    //正解
    public int singleNumber1(int[] nums) {
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp ^= nums[i];
        }
        return temp;
    }
}
