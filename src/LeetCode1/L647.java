package LeetCode1;

public class L647 {
    int num = 0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            count(s,i,i);//回文串长度为奇数
            count(s,i,i+1);//回文串长度为偶数
        }
        return num;
    }

    private void count(String s, int start, int end) {
        while (start >= 0&& end < s.length()
                && s.charAt(start) == s.charAt(end)){//中心拓展法
            num++;
            start--;
            end++;
        }
    }
}
