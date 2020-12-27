package LeetCode;

/**
 * @Author LT
 * @Date 2020/12/6 21:33
 * @Version 1.0
 * @Description
 */
public class L88 {
    public static void main(String[] args) {
        int [] num1 = new int[10];
        int[] num2 = {1};
        merge(num1, 0, num2, 1);
        for (int i = 0; i < num1.length; i++) {
            System.out.println(num1[i]);
        }
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0){
            if (nums1[p1] < nums2[p2]){
                nums1[p] = nums2[p2];
                p--;
                p2--;
            }else {
                nums1[p] = nums1[p1];
                p--;
                p1--;
            }
        }

        while (p2 >= 0){//为了防止主函数的测试用例的问题
            nums1[p--] = nums2[p2--];
        }
    }
}
