package LeetCode;

public class L34 {
    public static void main(String[] args) {
        System.out.println(5/2);//2
    }
    public int[] searchRange(int[] nums, int target) {
        /**
         * 首先，对 nums 数组从左到右做线性遍历，当遇到 target 时中止。
         * 如果没有中止过，那么 target 不存在，返回 [-1, -1] 。如果找到了有效的左端点坐标，
         * 第二遍线性扫描，但这次从右往左进行。
         * 这一次，第一个遇到的 target 将是最右边的一个
         */
     /*   int[] res = {-1,-1};
        int start = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                res[0] = i;
                for (int j = nums.length - 1; j >= 0; j--) {
                    if (nums[j] == target){
                        res[1] = j;
                        break;//不可少
                    }
                }
                break;//不可少
            }
        }
       return res;*/

        //超时
       int[] res = {-1, -1};
        int index = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right){
            //计算 mid 时需要防止溢出，
            // left + (right - left) / 2 和 (left + right) / 2 的结果相同，
            // 但是有效防止了 left 和 right 太大直接相加导致溢出。
            int mid = (left + right)/2;
            if (target == nums[mid]){//修改此部分后不会超时了
                while (nums[right] > target)
                    right--;
                while (nums[left] < target){
                    left++;
                }
                res[0] = left;
                res[1] = right;
                return res;
                //break;//不要忘记结束条件
            }else if (target > nums[mid]){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return res;
    }
}
