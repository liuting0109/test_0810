package LeetCode;

import java.util.*;

/**
 * @Author LT
 * @Date 2020/9/10 18:40
 * @Version 1.0
 * @Description
 */
//最小覆盖子串
public class L76 {
    public static void main(String[] args) {
        String S = "ADOBECODEBANC", T = "ABC";
        System.out.println(minWindow1(S, T));
    }
    static Map<Character, Integer> ori = new HashMap<Character, Integer>();
    static Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    public static String minWindow1(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        int[] hash = new int[128];
        for(char c:tt) {
            hash[c]++;
            System.out.println(c + " " +hash[c]);
        }

        /*for(int i : hash){
            if (hash[i] > 0){
                System.out.println(i +" "+hash[i]);
            }
        }*/
        int start=0,minLen = 0x7fffffff; //最小子串的起始位置，长度
        int count = 0;

        for(int l=0,r=0;r<ss.length;r++){
            if(--hash[ss[r]] >= 0) count++; //这表明ss[r]是T中的字符
            while(count == tt.length) {
                if(r - l + 1 < minLen) {
                    start = l;
                    minLen = r - l + 1;
                }
                if(++hash[ss[l++]]>0) {
                    System.out.println(l +" " + hash[ss[l]]);
                    count--;
                }
                /*if (hash[ss[l]] > 0){
                    System.out.println(ss[l]+" "+hash[ss[l]]);
                    count--;
                    hash[ss[l]]++;
                    l ++;

                }else {
                    System.out.println(ss[l]+" "+hash[ss[l]]);
                    hash[ss[l]]++;
                    l++;
                }*/
            }
        }
        return minLen==0x7fffffff?"":s.substring(start,start+minLen);
    }
    public static String minWindow(String s, String t) {
        if (s == null || s == "" || t == null || t == "" || s.length() < t.length()) {
            return "";
        }
        //维护两个数组，记录已有字符串指定字符的出现次数，和目标字符串指定字符的出现次数
        //ASCII表总长128
        int[] need = new int[128];
        int[] have = new int[128];
        //将目标字符串指定字符的出现次数记录
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        //分别为左指针，右指针，最小长度(初始值为一定不可达到的长度)
        //已有字符串中目标字符串指定字符的出现总频次以及最小覆盖子串在原字符串中的起始位置
        int left = 0, right = 0, min = s.length() + 1, count = 0, start = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            //说明该字符不被目标字符串需要，此时有两种情况
            // 1.循环刚开始，那么直接移动右指针即可，不需要做多余判断
            // 2.循环已经开始一段时间，此处又有两种情况
            //  2.1 上一次条件不满足，已有字符串指定字符出现次数不满足目标字符串指定字符出现次数，那么此时
            //      如果该字符还不被目标字符串需要，就不需要进行多余判断，右指针移动即可
            //  2.2 左指针已经移动完毕，那么此时就相当于循环刚开始，同理直接移动右指针
            if (need[r] == 0) {
                right++;
                continue;
            }
            //当且仅当已有字符串目标字符出现的次数小于目标字符串字符的出现次数时，count才会+1
            //是为了后续能直接判断已有字符串是否已经包含了目标字符串的所有字符，不需要挨个比对字符出现的次数
            if (have[r] < need[r]) {
                count++;
            }
            //已有字符串中目标字符出现的次数+1
            have[r]++;
            //移动右指针
            right++;
            //当且仅当已有字符串已经包含了所有目标字符串的字符，且出现频次一定大于或等于指定频次
            while (count == t.length()) {
                //挡窗口的长度比已有的最短值小时，更改最小值，并记录起始位置
                if (right - left < min) {
                    min = right - left;
                    start = left;
                }
                //如果左边即将要去掉的字符不被目标字符串需要，那么不需要多余判断，直接可以移动左指针
                char l = s.charAt(left);
                if (need[l] == 0) {
                    left++;
                    continue;
                }
                //如果左边即将要去掉的字符被目标字符串需要，且出现的频次正好等于指定频次，那么如果去掉了这个字符，
                //就不满足覆盖子串的条件，此时要破坏循环条件跳出循环，即控制目标字符串指定字符的出现总频次(count）-1
                if (have[l] == need[l]) {
                    count--;
                }
                //已有字符串中目标字符出现的次数-1
                have[l]--;
                left++;//移动左指针
            }
        }
            //如果最小长度还为初始值，说明没有符合条件的子串
        if (min == s.length() + 1){
            return "";
        }
        return s.substring(start, start + min);
    }
}
