package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author LT
 * @Date 2020/9/10 22:35
 * @Version 1.0
 * @Description 最长连续序列
 */
public class L128 {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2, 4};//4
//        int[] nums = {0,3,7,2,5,8,4,6,0,1};//9

        System.out.println(longestConsecutive(nums));
    }

    /*
    要求 O(n) 复杂度。
    用哈希表存储每个端点值对应连续区间的长度
    若数已在哈希表中：跳过不做处理
    若是新数加入：
    取出其左右相邻数已有的连续区间长度 left 和 right
    计算当前数的区间长度为：cur_length = left + right + 1
    根据 cur_length 更新最大长度 max_length 的值
    更新区间两端点的长度值
     */
    public static int longestConsecutive(int[] nums) {
        //todo review
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.get(num - 1) == null ? 0 : map.get(num - 1);
                int right = map.get(num + 1) == null ? 0 : map.get(num + 1);

                int cur = left + right + 1;
                res = Math.max(cur, res);

                map.put(num, cur);
                map.put(num - left, cur);// 更新最左侧
                map.put(num + right, cur);// 更新最右侧
                System.out.println(map);
            }
        }
        return res;
    }

    public static int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i : nums) {
            set.add(i);
        }
        for (int num : set) {
            int cur = num;
            // 只有当num-1不存在时，才开始向后遍历num+1，num+2，num+3
            if (!set.contains(cur - 1)) {
                while (set.contains(cur + 1)) {
                    cur++;
                }
            }
            // [num, cur]之间是连续的，数字有cur - num + 1个
            ans = Math.max(ans, cur - num + 1);
        }
        return ans;
    }

    //与方法2异曲同工
    public static int longestConsecutive3(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);// 把 nums 转成哈希集合
        }
        for (Integer x : set) {
            if (set.contains(x - 1)) {// 如果 x 不是序列的起点，直接跳过
                continue;
            }
            int y = x + 1;
            while (set.contains(y)) {// 不断查找下一个数是否在哈希集合中
                y++;
            }
            // 循环结束后，y-1 是最后一个在哈希集合中的数,从 x 到 y-1 一共 y-x 个数
            res = Math.max(y - x, res);
        }
        return res;
    }
}
