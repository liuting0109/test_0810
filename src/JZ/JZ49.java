package JZ;
/*
将一个字符串转换成一个整数，
要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 */
public class JZ49 {
    public static void main(String[] args) {
       // System.out.println(Integer.MAX_VALUE);
        System.out.println(StrToInt1("-12"));
    }
    public static int StrToInt(String str) {

        if (str == null || str.length() == 0)//边界判断不要忘,if (str.length() == 0 || str == null)顺序错误
            return 0;
        char[] chars = str.toCharArray();
        /*boolean flag = false;//简化写法
        if (chars[0] == '+' || chars[0] != '-')
            flag = true;*/

        boolean flag = chars[0] == '-';
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-')){
                continue;
            }
            if (c > '9' || c < '0'){
                return 0;
            }
            res *= 10;
            res += c - '0';//!!!!!!!!ASCII码
        }
        /*for (int i = 0; i < chars.length; i++) {//错误
            if (chars[i] > '9' || chars[i] < '0'){
                return 0;
            }
            res *= 10;
            res += chars[i];
        }*/
        return  (flag == false) ?res : -res;
    }

    public static int StrToInt1(String str){
        if (str == null || str.length() == 0)
            return 0;
        int res = 0;
        boolean isNegative = str.charAt(0) == '-'?true : false;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(i == 0 && (chars[0] == '+' || chars[0] == '-'))//if(chars[0] == '+' || chars[0] == '-')//写法错误，
                // 因为会永远continue
                continue;
            if (chars[i] > '9' || chars[i] < '0') {//if (chars[i] >9 || chars[i] < 0) 错误，因为不是9，而是‘9’
                System.out.println(chars[i]);
                return 0;
            }

            res = res * 10 + (chars[i] - '0');
        }
        if (isNegative == true)
            return -res;
        else
            return res;
    }
}
