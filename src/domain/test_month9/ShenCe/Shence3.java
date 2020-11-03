package domain.test_month9.ShenCe;


import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/14 21:22
 * @Version 1.0
 * @Description
 */
public class Shence3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        boolean res = fun3(str1, str2);
        System.out.println(res);
    }

    private static boolean fun3(String str1, String str2) {

        if (str1 == null || str1.length() == 0)
            return false;
        if (str1.length() != str2.length())
            return false;
        //char[] chars = str1.toCharArray();
        for (int i = 0; i < str1.length(); i++) {
            for (int j = i + 1; j < str1.length(); j++) {
                if (help(str1, str2, i, j))
                    return true;
            }
        }
        return false;
    }

    private static boolean help(String str1, String str2, int i, int j) {
        char[] c1 = str1.toCharArray();
        char temp = c1[i];
        c1[i] = c1[j];
        c1[j] = temp;

        String ss = String.valueOf(c1);
        if (ss.equals(str2))
            return true;
        else
            return false;
    }

}
