package domain.test_month9.ShenCe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/14 21:22
 * @Version 1.0
 * @Description
 */
public class Shence2 {
    static ArrayList<String> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        fun2(str);
        Collections.sort(res);
        for (int i = 0; i < res.size(); i++) {
            if (i == 0){
                System.out.print("[" + "'"+ res.get(i)+ "',");
            }else if (i == res.size() - 1){
                System.out.print( "'"+ res.get(i)+ "'"+"]");
            }else {
                System.out.print( "'"+ res.get(i)+ "',");
            }
        }
        //System.out.println(res);
    }

    public static void fun2(String str){
        if (str == null || str.length() == 0)
            return;
        char[] chars = str.toCharArray();
        helper(chars, 0);
    }

    public static void helper(char[] chars, int i){
        if (i == chars.length -1){
            String s = String.valueOf(chars);
            res.add(s);
        }else {
            for (int j = i; j < chars.length; j++) {
                swap(chars, i, j);
                helper(chars, i + 1);
                swap(chars, i, j);
            }
        }
    }

    public static void swap(char[] chars, int i , int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
