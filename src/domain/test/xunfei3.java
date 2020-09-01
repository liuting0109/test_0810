package domain.test;

import java.util.Scanner;
//ac  输入：____aaa__b____c_dd___
//输出 aaa_b_c_dd
public class xunfei3 {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        String string = sc.next();*/
        String string = "aaa__b____c_dd";
        fun(string);
    }

    private static void fun(String string) {
        int len = string.length();
        //System.out.println(string.replaceAll("_+","_"));

        if (string.charAt(0) == '_' && string.charAt(len - 1) == '_'){
            System.out.println(string.replaceAll("_+","_").
                    substring(1,string.replaceAll("_+","_").length() - 1));
        }else if (string.charAt(0) == '_' && string.charAt(len - 1) != '_'){
            System.out.println(string.replaceAll("_+","_").substring(1));
        }else if (string.charAt(0) != '_' && string.charAt(len - 1) == '_'){
            System.out.println(string.replaceAll("_+","_").
                    substring(0,string.replaceAll("_+","_").length() - 1));
        }else {
            System.out.println(string.replaceAll("_+","_"));
        }

        //System.out.println(string.replaceAll("_+","_").length());
        for (int i = 0; i < string.length(); i++) {

        }
    }
}
