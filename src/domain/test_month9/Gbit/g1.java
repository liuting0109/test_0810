package domain.test_month9.Gbit;

import java.util.HashMap;
import java.util.Scanner;


/**
 * @Author LT
 * @Date 2020/9/25 21:15
 * @Version 1.0
 * @Description
 */
public class g1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = sc.next();
        String content = sc.next();
        int res = fun(pattern, content);
        System.out.println(res);
    }

    private static int fun(String pattern, String content) {
        int count = 0;
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            map.put(pattern.charAt(i), null);

        }
        if (map.size() == 1)
            return 1;
        /*if (map.size() == 2){
            for (int i = 0; i < ; i++) {

            }
        }*/

        return count;
    }
}
