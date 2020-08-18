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
        //System.out.println(ReverseSentence(s));
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
}
