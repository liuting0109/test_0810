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
    public static void main(String[] args) {
        //s = "bbbbb" : 1       "pwwkew":3
        String s = "abcabcbb";//3
        System.out.println(lengthOfLongestSubstring3(s));
    }

    /**
     * 标签：滑动窗口
     * 定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置
     * 我们定义不重复子串的开始位置为 start，结束位置为 end
     * 随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，
     * 此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符
     * 无论是否更新 start，都会更新其 map 数据结构和结果 ans。
     * 时间复杂度：O(n)
     */
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, start = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (map.containsKey(temp)) {
                start = Math.max(start, map.get(temp) + 1);
            }
            map.put(temp, i);
            res = Math.max(res, i - start + 1);
        }
        return res;
    }

    /**
     * left = Math.max(left,map.get(s.charAt(i)) + 1);
     * left是子串的起始位置
     * 遇到重复元素的就把重复元素下标+1作为子串的起始位置left，即 left = map.get(s.charAt(i)) + 1；
     * 但由于有 'abba' 这样的字符，当 ‘b’ 重复时，left 已经记作2，
     * 再次循环，遇到重复元素 ‘a’ 时 , left就会被记作1，这样子串起始位置left就从2倒退回1了 ，乱掉了。
     * 所以为了再次循环到重复元素 ‘a’ 时，防止left 子串起始位置不倒回去，保持之前重复元素 ‘b’的值,
     * 就对比一下老的left 和新的left = map.get(s.charAt(i)) + 1
     * 谁大，就是正确的left , 即left = Math.max(left,map.get(s.charAt(i)) + 1)
     */
    public static int lengthOfLongestSubstring2(String s) {
        int res = 0, left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);

            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    public static int lengthOfLongestSubstring3(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, start = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (map.containsKey(temp)) {
                start = Math.max(start, map.get(temp) + 1);
            }
//            else {
            map.put(temp, i);
//            }
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}
