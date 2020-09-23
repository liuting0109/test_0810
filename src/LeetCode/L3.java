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
