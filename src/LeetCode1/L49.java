package LeetCode1;

import java.util.*;

public class L49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        //int[] count = new int[26];//26个字母
        for (String s :strs){
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)){
                ans.put(key,new ArrayList());
            }
            ans.get(key).add(s);
        }
        //return new ArrayList<>(ans.values());//错误
        return new ArrayList(ans.values());
    }
}
