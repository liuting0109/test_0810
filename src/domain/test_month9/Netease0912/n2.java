package domain.test_month9.Netease0912;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/12 15:33
 * @Version 1.0
 * @Description
 */
//LC1371每个元音包含偶数次的最长字符串
public class n2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        fun(str);
    }

    private static void fun(String str) {
        int res = 0;
        char[] chars = str.toCharArray();
        int[] even = new int[128];
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                for (int k = i; k <= j; k++) {
                    even[chars[k]] ++;
                }
                if ((even['a'] % 2== 0) && (even['b'] % 2== 0) && (even['c'] % 2== 0) && (even['x'] % 2== 0) && (even['y'] % 2== 0) && (even['z'] % 2== 0)){
                    int temp =j - i + 1;
                    res = Math.max(res,temp);
                }
                Arrays.fill(even, 0);
            }
            //Arrays.fill(even, 0);
        }
        System.out.println(res);
    }
}
