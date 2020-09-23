package domain.test_month9.Tencent;

import java.util.*;

/*
输出前k多和前k少的字符串
4 2 1 2 3 4
4 2 1 1 2 3
7 2 bb bb c c a a a
 */
public class Tencent3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String[] str = new  String[n];
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }
        fun(str, k);
    }

    public static void fun(String[] str, int k){
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            map.put(str[i], map.getOrDefault(str[i], 0) + 1);
        }
        for(String s: map.keySet()){
            System.out.println(s+ " "+ map.get(s));
        }

        /*for (int i = 0; i < k; i++) {
            System.out.println(" "+ map.get(i));
            map.size();

        }*/
        List list = new LinkedList(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()){
                    String s1 = o1.getKey();
                    String s2 = o2.getKey();
                    for (int i = 0; i < s1.length() && i < s2.length(); i++) {
                        if (s1.charAt(i) != s2.charAt(i)) {
                            return s1.charAt(i) - s2.charAt(i);
                        }
                    }
                    if (s1.length() < s2.length()){
                        return 1;
                    }else {
                        return -1;
                    }
                }
                return o1.getValue() - o1.getValue();
            }
        });
        for(String s: map.keySet()){
            System.out.println(s+ " "+ map.get(s));
        }
        return;
    }
}
