package domain.test_month9.JingDong;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
//题解 https://blog.csdn.net/u014377853/article/details/108653154
/**
 * @Author LT
 * @Date 2020/9/17 19:41
 * @Version 1.0
 * @Description
 */
/*
题目描述：
小明想从一段英文短文中提取潜在的年份信息，待匹配的年份的范围为1000年至3999年，包含1000和3999。

输入一段英文短文，按出现次序输出所提取到的所有可能的年份字符串。



输入描述
单组输入，输入一段英文短文，可能包含字母大小写，标点符号及空格。（不超过2000个字符）

输出描述
输出所提取到的所有可能的年份字符串，两两之间用一个空格隔开。


样例输入
And millionaires will hold 46% of total wealth by 2019, the report says. This ratio is likely to increase in 2020.
样例输出
2019 2020
 */
public class Jingdong1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
       /* String ss = "And millionaires will hold 46% of total wealth by 2019, " +
                "the report says. This ratio is likely to increase in 2020.";
        String test = "12345";
        System.out.println(test.substring(0,3));
        String regex = "[0-9][0-9][0-9][0-9][0-9]";
        System.out.println(Pattern.matches(regex,test));*/
        //：201003abc2020 输出：2020
        ArrayList<String> res = fun(str);
        for (String s: res){
            System.out.print(s +" ");
        }
    }

    private static ArrayList<String>  fun(String str) {
        String regex = "[1-3][0-9][0-9][0-9]";
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < str.length() - 3; i++) {
            String temp = str.substring(i, i + 4);
            if (i == str.length() - 4 && Pattern.matches(regex, temp)&&
                    (str.charAt(i - 1) >'9'||str.charAt(i - 1) < '0')){
                res.add(temp);
                i += 3;
            } else if (Pattern.matches(regex, temp) &&
                    (str.charAt(i + 4) >'9'||str.charAt(i + 4) < '0')
                    &&
                    (str.charAt(i - 1) >'9'||str.charAt(i - 1) < '0')){
                res.add(temp);
                 i += 3;
            }else if (i == 0 && Pattern.matches(regex, temp)&&
                    (str.charAt(i + 4) >'9'||str.charAt(i + 4) < '0')){
                res.add(temp);
                i += 3;
            }
        }
        //System.out.println(res);
        return res;
    }
}
