package domain.test;

import java.util.Scanner;
/*
对于一段仅由小写字母组成的连续字符串(即字符串内不包含空格)，
你需要在每一个字母’n’之前添加一个换行符，即在下一行继续输出，
同时根据文本规范，每一行的首字母都需要大写,如果第一行第一个字母就是’n’,当然是不用换行的。
请你输出格式化之后的文本。
输入描述
输入仅包含一行，即一个仅由小写字母组成的字符串s，s的长度小于等于3000。
输出描述
输出包含若干行，即格式化之后的结果。
样例输入
wotainanle
样例输出
Wotai
Na
Nle
 */
public class T360 {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        String str = sc.next();
        fun(str);*/
        String str = "notainanle";
        fun1(str);
        /*char aa = 'a';
        aa -= 32;
        System.out.println(aa);*/
        //System.out.println();
    }
    public static void fun1 (String str){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0){
                char temp = str.charAt(0);
                temp -= 32;
                sb.append(temp);
            }
            else if (str.charAt(i) =='n'){
                sb.append('N');
            }else {
                sb.append(str.charAt(i));
            }
        }
        //System.out.println(sb.toString());//WotaiNaNle

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 'N' && i != 0){
                System.out.println();
                System.out.print(sb.charAt(i));
            }else {
                System.out.print(sb.charAt(i));
            }
        }
    }
    public static void fun (String str){

    }
}
