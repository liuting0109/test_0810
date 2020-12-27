package LeetCode;

import java.util.Arrays;

public class L621 {
    public static void main(String[] args) {
        char[] tasks = {'A','B','C','A'};
        int[] map = new int[26];
        for (char c: tasks){
            map[c - 'A']++;//统计每个字符串出现的次数
        }
        for (int i:map){
            System.out.println(i);
        }
        System.out.println(map);
    }

    public int leastInterval(char[] tasks, int n) {
        int res = 0;
        int[] map = new int[26];
        for (char c: tasks){
            map[c - 'A']++;//统计每个字符串出现的次数
        }
        Arrays.sort(map);
        while (map[25] > 0){
            int i = 0;
            while (i <= n){
                if (map[25] == 0) break;
                if (i < 26 && map[25 - i] > 0)
                    map[25 - i] --;
                res++;
                i++;
            }
            Arrays.sort(map);
        }
        return res;
    }
}
