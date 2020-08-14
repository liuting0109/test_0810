package JZ;

public class JZ2 {
    public String replaceSpace(StringBuffer str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                sb.append("%20");
            else
                sb.append(str.charAt(i));
        }
        return sb.toString();
        //return str.toString().replace(" ", "%20");
    }
}
