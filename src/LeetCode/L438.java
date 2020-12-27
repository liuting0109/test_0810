package LeetCode;

import java.util.*;

public class L438 {
    public List<Integer> findAnagrams1(String s, String p) {
        char[] arrS = s.toCharArray();
        char[] arrP = p.toCharArray();
        List<Integer> res = new ArrayList<>();
        int[] needs = new int[26];// 定义一个 needs 数组来看 arrP 中包含元素的个数
        int[] windows = new int[26];
        for (int i = 0; i < arrP.length; i++) {
            needs[arrP[i] - 'a'] += 1;
        } // 先将 arrP 中的元素保存到 needs 数组中
        int left = 0, right = 0;
        while (right < arrS.length){
            // 将右窗口当前访问到的元素 curR 个数加 1
            int curR = arrS[right] -'a';
            windows[curR] += 1;
            right++;
            // 当 window 数组中 curR 比 needs 数组中对应元素的个数要多的时候就该移动左窗口指针
            while (windows[curR] > needs[curR]){
                int curL = arrS[left] - 'a';
                left++;
                windows[curL]--;
            }

            //if (right - left +1 ==p.length())//错的
            if (right - left == arrP.length)
                res.add(left);
        }
        return res;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c: p.toCharArray()){// 用 map 存储目标值中各个单词出现的次数
            map.put(c,map.getOrDefault(c, 0)+1);
        }
        // 用另外一个 map 存储滑动窗口中有效字符出现的次数
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int valid = p.length();
        // 只有当 valid == 0 时，才说明 window 中包含了目标子串
        while (right < s.length()){
            if (map.containsKey(s.charAt(right))){
                // 如果目标子串中包含了该字符，才存入 window 中
                window.put(s.charAt(right),window.getOrDefault(s.charAt(right),0) +1);
                // 只有当 window 中该有效字符数量不大于map中该字符数量，才能算一次有效包含
                if (window.get(s.charAt(right)) <= map.get(s.charAt(right))){
                    valid--;
                }
            }
            // 如果 window 符合要求，即两个 map 存储的有效字符相同，就可以移动左指针了
            // 但是只有二个map存储的数据完全相同，才可以记录当前的起始索引，也就是left指针所在位置
            while (valid == 0){
                if (right - left + 1==p.length()) res.add(left);
                // 如果左指针指的是有效字符,需要更改 window 中的 key 对应的 value
                // 如果 有效字符对应的数量比目标子串少，说明无法匹配了
                if (map.containsKey(s.charAt(left))){
                    window.put(s.charAt(left),window.get(s.charAt(left)) - 1);
                    if (window.get(s.charAt(left)) < map.get(s.charAt(left))){
                        valid++;
                    }
                }
                left++;
            }
            right++;
        }
        return res;
    }
}
