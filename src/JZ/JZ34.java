package JZ;

import java.util.HashMap;

public class JZ34 {
    public static void main(String[] args) {
        String str = "hellohe";
        System.out.println(FirstNotRepeatingChar(str));
    }
    public static int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
            System.out.println(c+" " + map.get(c));
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.get(c) == 1)
                return i;
        }
        return -1;
    }
}
