package JZ;
/*
循环左移（ROL），用字符串模拟这个指令的运算结果。
对于一个给定的字符序列S，把其循环左移K位后的序列输出。
例如，字符序列S=”abcXYZdef”,
要求输出循环左移3位后的结果，即“XYZdefabc”
 */
public class JZ43 {
    public static void main(String[] args) {
        String S = "abcXYZdef";
        //String S = "abcdefg";
        //String res =
        System.out.println(LeftRotateString1(S, 3));

    }
    public static String LeftRotateString1(String str,int n) {
        int len = str.length();
        if (len == 0)
            return str;
        str += str;
        System.out.println(str);
        n = n % len;
        return str.substring(n, len + n);
    }

    public static String LeftRotateString(String str,int n) {
        if (n >= str.length())//if (n <= 0)//错误
            return str;
        return str.substring(n) + str.substring(0, n);
    }
}
