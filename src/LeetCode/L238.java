package LeetCode;

/**
 * @Author LT
 * @Date 2020/12/27 15:46
 * @Version 1.0
 * @Description
 */
public class L238 {
    public static void main(String[] args) {
        int[] num = {1,2,3,4};
        int[] res = productExceptSelf(num);
        for (int i:res) {
            System.out.print(i+" ");
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {//需要初始化为1，不然结果都是0
            res[i] = 1;
        }
        int left = 1, right = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] *=left;
            left *= nums[i];

            res[nums.length - i -1]*= right;
            right *= nums[nums.length - i -1];
        }
        return res;
    }
}
