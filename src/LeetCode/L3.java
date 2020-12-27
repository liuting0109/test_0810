package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author LT
 * @Date 2020/9/11 12:00
 * @Version 1.0
 * @Description
 */
public class L3 {
    /**
     * 标签：滑动窗口
     * 定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置
     * 我们定义不重复子串的开始位置为 start，结束位置为 end
     * 随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符
     * 无论是否更新 start，都会更新其 map 数据结构和结果 ans。
     * 时间复杂度：O(n)
     */
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, start = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (map.containsKey(temp)){
                start = Math.max(start, map.get(temp) + 1);
            }
            map.put(temp,i);
            res = Math.max(res,i - start + 1);
        }
        return res;
    }
}
