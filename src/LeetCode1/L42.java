package LeetCode1;

public class L42 {
    public int trap(int[] height) {
        //双指针
        int left = 0, right = height.length - 1;
        int res = 0;
        int left_max = 0, right_max = 0;
        while (left < right){
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                }
                else
                    res += left_max - height[left];
                left++;
            }else {
                if (height[right] >= right_max){
                    right_max = height[right];
                }else {
                    res += right_max - height[right];
                }
                right --;
            }
        }
        return res;
    }
}
