package JZ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/*
输入一个字符串,按字典序打印出该字符串中字符的所有排列。
例如输入字符串abc,
则按字典序打印出由字符a,b,c所能排列出来的所有字符串
abc,acb,bac,bca,cab和cba。
还要去重
 */
public class JZ27 {
    public static void main(String[] args) {
        String str = "abc";
        //System.out.println(str.substring(1));
        System.out.println(Permutation(str));
    }
    public static ArrayList<String> Permutation(String str) {
        StringBuffer sb = new StringBuffer(str);
        ArrayList<String> res = help(sb);
        return res;
    }

    private static ArrayList<String> help(StringBuffer str) {
        ArrayList<String> res = new ArrayList<>();
        if (str.length() == 1)
            res.add(str.toString());
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 || str.charAt(i) != str.charAt(0)){
                char temp = str.charAt(i);
                str.setCharAt(i, str.charAt(0));
                str.setCharAt(0, temp);
                ArrayList<String> newResult =
                        help(new StringBuffer(str.substring(1)));

                for (int j = 0; j < newResult.size(); j++) {
                    res.add(str.substring(0,1) + newResult.get(j));
                }
                temp = str.charAt(0);
                str.setCharAt(0, str.charAt(i));
                str.setCharAt(i, temp);
            }
        }
        Collections.sort(res);//需要在做一个排序操作
        return res;
    }

    public static ArrayList<String> Permutation1(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0)
            return res;
        HashSet<String> set = new HashSet<>();
        return res;
    }
    public static void fun(HashSet<String> res,char[] str, int k){
        if (k == str.length){
            res.add(new String(str));
            return;
        }


    }
}
