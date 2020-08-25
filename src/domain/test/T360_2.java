package domain.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
        /*Scanner sc= new Scanner(System.in);
        String[] str = new String[20];
        int index = 0;
        while (sc.hasNext()){
            str[index++] = sc.next();
        }
        ArrayList<String> res = fun(str);
        //System.out.println(res.size());
        for (String s: res){
            System.out.println(s);
        }*/
        solution();
        /*String[] strings = {
                "ABA","AHA","HHA"
        };
        //System.out.println(help(strings[0]));
        System.out.println(fun(strings));*/
    }
    //方法2
    public static void solution(){
        Set<Character> set = new HashSet<>();
        char[] chars = {'A','H','I','M','O','T','U','V','M','X'};
        for (char c:chars){
            set.add(c);
        }
        int left = 0, right = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            left =0;
            right = s.length() - 1;
            while (left <= right){
                if (s.charAt(left) == s.charAt(right) && set.contains(s.charAt(left))){
                    left ++;
                    right --;
                }else {
                    break;
                }
            }
            if (left > right)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
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
        //用这个判断亦可
        String ss = "AHIMOTUVWXY";
        ss.contains("a");

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
