package domain.test;

import java.util.ArrayList;
import java.util.Scanner;
/*
在一张透明的纸上，用笔写下一个字符串。
然后将纸翻面，请你判断正面和背面看到的字符串是否一样。
请注意，字符串在正反面看上去一样，
必须要求每个字符是左右对称的，比如'W'字符是左右对称的，而'N'不是。
输入描述
输入包含多组数据，每组数据一行，包含一个全由大写字母构成的字符串S。
输出描述
如果正面和背面看到的字符串一样。输出YES，否则输出NO
样例输入
ABA
AHA
HHA
样例输出
NO
YES
NO
提示
|S|≤1000，数据组数不会超过20
ABA在背面看过去的时候，B是反着写的，所以不一样。
HHA在背面看过去为AHH
规则
 */
public class T360_2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String[] str = new String[20];
        int index = 0;
        while (sc.hasNext()){
            str[index++] = sc.next();
        }
        ArrayList<String> res = fun(str);
        //System.out.println(res.size());
        for (String s: res){
            System.out.println(s);
        }
        /*String[] strings = {
                "ABA","AHA","HHA"
        };
        //System.out.println(help(strings[0]));
        System.out.println(fun(strings));*/
    }

    private static ArrayList<String> fun(String[] str) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            String temp = str[i];
            if (huiWen(temp)){
                if (help(temp)){
                    res.add("YES");
                }else {
                    res.add("NO");
                }
            }else {
                res.add("NO");
            }
        }
        return res;
    }

    public static boolean help(String str){
        ArrayList<Character> sym = new ArrayList<>();//对称字母
        sym.add('A');
        sym.add('H');
        sym.add('I');
        sym.add('M');
        sym.add('O');
        sym.add('T');
        sym.add('U');
        sym.add('V');
        sym.add('W');
        sym.add('X');
        sym.add('Y');

        for (int i = 0; i < str.length(); i++) {
            if (!sym.contains(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean huiWen(String str){
        int i = 0;
        int j = str.length() - 1;
        while (i < j){
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
