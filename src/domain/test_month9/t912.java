package domain.test_month9;

/**
 * @Author LT
 * @Date 2020/9/12 9:20
 * @Version 1.0
 * @Description
 */
public class t912 {
    public static void main(String[] args) {
        System.out.println(add2Sum(new String("123"), new String("3945")));
    }
    //大数加法
    private static String add2Sum(String num1, String num2) {
        String n1 = new StringBuffer(num1).reverse().toString();
        String n2 = new StringBuffer(num2).reverse().toString();
        int len1 = n1.length();
        int len2 = n2.length();
        int maxLen = Math.max(len1, len2);
        if (len1 < len2){
            for (int i = len1; i < len2; i++) { n1+="0"; }
        }else {
            for (int i = len2; i < len1; i++) { n2+="0"; }
        }
        StringBuffer res = new StringBuffer();
        int carry = 0;//进位
        for (int i = 0; i < maxLen; i++) {//字符串下标为i的字符转换成整型赋值给t
            int nsum = Integer.parseInt(n1.charAt(i) + "")+
                    Integer.parseInt(n2.charAt(i)+"") + carry;
            int temp = nsum % 10;
            res.append(temp);
            carry = (nsum/10);
        }
        if (carry > 0){ res.append(carry); }
        return res.reverse().toString();
    }
}
