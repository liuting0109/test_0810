package domain.test_month10.HelloChuXing;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author LT
 * @Date 2020/10/11 17:29
 * @Version 1.0
 * @Description
 */
//最长不重复子串
//ac
public class t1 {
    public static void main(String[] args) {
        String s = "abcdabcdabcdefg";
        String str = "ababc defg";
        String ss = "The Linux kernel is an open source software project of fairly large scope.";
        System.out.println(findMaxSubstr(str));
    }
    public static String findMaxSubstr (String str) {
        // write code here

        int maxLen = 0;

        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (map.containsKey(temp)){
                start = Math.max(start, map.get(temp) + 1);
            }
            map.put(temp, i);
            if (maxLen < i -start + 1){
                maxLen = i - start + 1;
                end = i;
                //System.out.println(maxLen);
            }
            //maxLen = Math.max(maxLen, i - start + 1);
        }
        String res = str.substring(end - maxLen + 1, end + 1);
        return res;
    }
}
