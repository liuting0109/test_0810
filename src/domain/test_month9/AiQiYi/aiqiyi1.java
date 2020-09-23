package domain.test_month9.AiQiYi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/13 15:44
 * @Version 1.0
 * @Description
 */
public class aiqiyi1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        longest(str);
    }
    public static void longest(String str){
        int n = str.length();
        int res = 0;

        Map<Character, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)){
                index = Math.max(map.get(c), index);
            }
            res = Math.max(res, i - index + 1);
            map.put(str.charAt(i), i + 1);
        }
        System.out.println(res);

    }
}
