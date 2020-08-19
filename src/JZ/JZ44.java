package JZ;
/*
例如，“student. a am I”。
正确的句子应该是“I am a student.”
 */
public class JZ44 {
    public static void main(String[] args) {
        String s = "I am a student.";
        //String s = "  ";
        System.out.println("+++");
        System.out.println(s.trim());
        System.out.println("+++");
        System.out.println(ReverseSentence1(s));
    }
    public static String ReverseSentence(String str) {
        //System.out.println();str.trim()
        StringBuffer sb = new StringBuffer();
        String[] temp = str.split(" +");
        for (int i = temp.length - 1; i > 0; i--) {
            sb.append(temp[i]).append(" ");
        }
        sb.append(temp[0]);
        return sb.toString();
    }
    public static String ReverseSentence1(String str) {
        if (str.trim().equals(""))
            return str;
        //转为char型进行交换
        char[] chars = str.toCharArray();
        int len = chars.length;
        int blank = 0;
        reverse(chars, 0, len - 1);//先整体翻转
        for (int i = 0; i < len; i++) {//局部翻转
            if (chars[i] == ' '){
                int nextBlank = i;
                reverse(chars, blank, nextBlank - 1);
                blank = nextBlank + 1;
            }
        }
        reverse(chars, blank, len - 1);
        /*for (int i = 0; i < str.length() / 2; i++) {
            char temp = str.charAt(i);
            str.charAt(i) = str.charAt(str.length() - i);//无法直接错误

        }*/
        //return chars.toString();//上面的返回地址，错误
        return new String(chars);
    }
    public static void reverse(char[] chars, int i, int j){
        while (i < j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }
}
