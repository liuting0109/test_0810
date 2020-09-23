package domain.test_month9.DuXiaoMan;

import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/20 20:45
 * @Version 1.0
 * @Description
 */
public class d1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        fun(str1, str2);
    }

    private static void fun(String str1, String str2) {
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int res = 0;

        int[] hash1 = new int[128];
        for (int i = 0; i < c1.length; i++) {
            hash1[c1[i]]++;
        }

        int[] hash2 = new int[128];
        for (int i = 0; i < c2.length; i++) {
            hash2[c2[i]]++;
        }

        for (int i = 0; i < hash1.length; i++) {
            if (hash1[i] > 0){
                if (hash1[i] > hash2[i]){
                    res += hash2[i];
                }else {
                    res += hash1[i];
                }
            }
        }
        System.out.println(res);

    }
}
