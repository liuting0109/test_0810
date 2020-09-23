package domain.test_month9.ALi;

import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/11 9:03
 * @Version 1.0
 * @Description
 */
public class ALi1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String arr = sc.next();
        String[] matches = new  String[m];
        for (int i = 0; i < m; i++) {
            matches[i] = sc.next();
        }
       /* int n = 10;
        int m = 3;
        String arr = "helloworld";
        String[] matches = {"hello", "world","owo"};*/
        mingan(n,m,arr,matches);
    }
    public static void mingan(int n,int m , String arr, String[] mathches){
        int res = 0;
        int count = 0;
        for (int i = 0; i < mathches.length; i++) {
            count = fun(arr, mathches[i]);
            res +=count;
        }
        System.out.println(res);
    }

    private static int fun(String arr, String match) {
        int res = 0;
        for (int i = 0; i < arr.length() - match.length() + 1; i++) {
            String temp = arr.substring(i ,i + match.length());
            if (temp.compareTo(match) == 0){
                res++;
                i = i + match.length();
            }
        }
        //System.out.println(res);
        return res;
    }
}
