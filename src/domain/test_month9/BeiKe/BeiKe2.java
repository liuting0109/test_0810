package domain.test_month9.BeiKe;

import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/7 15:31
 * @Version 1.0
 * @Description
 */
/*
6
abcdef

9
ababababc
 */
public class BeiKe2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        //System.out.println(str.length());

        fun(n, str);
        /*fun(6,"abcdef");
        *//*String s = "ababababc";
        System.out.println(s.substring(4, 9));*//*
        fun(9,"ababababc");*/
    }

    public static void fun(int n, String str){
        int res = 0;
        //StringBuffer temp = new StringBuffer(str.charAt(0));
        for (int i = str.length() - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                res++;
            }else {
                int index = i / 2;
                //System.out.println(str.substring(0, index + 1));
                //System.out.println(str.substring(index, i + 1));
                if (str.substring(0, index + 1).equals(str.substring(index + 1, i + 1))) {
                    /*System.out.println(str.substring(0, index ));
                    System.out.println(str.substring(index, i + 1));*/
                    res += index + 1;
                    res++;
                    break;
                } else {
                    res++;
                }
            }
        }

        System.out.println(res);
    }
}
