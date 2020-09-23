package domain.test_month9.MI;
/*
注册网站时，需要使用包含不同类型（数字、符号、大写字母、小写字母）的字符，和特定长度。检查一个密码内容同时包含以上 4 种类型的字符，并且长度在8-120 个字符之间。符合要求，返回 0；长度不符合返回 1；类型不符合要求返还 2。
可以一次输入多组密码，以空格符间隔，空格符不作为密码。
输入描述
需要验证的密码，多个密码以空格符间隔，空格符不作为密码的一部分
输出描述
每个密码的检查结果，每个结果需要换行输出
样例输入
123 12345678 123abcABC!!!
样例输出
1
2
0
ac
 */
import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/8 17:53
 * @Version 1.0
 * @Description
 */
public class mi1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.next().trim();
            int res = fun(str);
            System.out.println(res);
        }
    }

    private static int fun(String str) {
        int len = str.length();
        if (len < 8 || len > 120){
            return 1;
        }
        boolean[] flag = new boolean[4];
        for (int i = 0; i < str.length(); i++) {
            if ('1' < str.charAt(i) && str.charAt(i) <'9'){
                flag[0] = true;
            }else if ('A' < str.charAt(i) && str.charAt(i) <'Z'){
                flag[1] = true;
            }else if ('a' < str.charAt(i) && str.charAt(i) <'z'){
                flag[2] = true;
            }else {
                flag[3] = true;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (flag[i] == false){
                return 2;
            }
        }
        return 0;
    }
}
