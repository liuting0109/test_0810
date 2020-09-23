package domain.test_month9.NetEase;

import java.util.HashMap;
import java.util.Scanner;

public class Neteas1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] info = new String[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                info[i][j] = sc.next();
            }
        }
        //System.out.println(fun1(info, n));
        fun1(info,n);
        /*int n = 3;
        String [][] info = {{"11", "李华"},{"12", "张三"},{"11", "李四"},{"15","李华"}};
        System.out.println(fun1(info, info.length));*/
    }

    private static int fun1(String[][] info, int n) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (info[i][0].equals(info[j][0])){
                    continue;
                }
                    //map.put(info[i][1],map.getOrDefault(info[i][1], 0) + 1);

            }
            //map.put(info[i][1],map.getOrDefault(info[i][1], 0) + 1);

        }
     /*   for (int i = 0; i < map.size(); i++) {
            System.out.println(map.);
        }*/
        for(String key: map.keySet()){
            if (map.get(key) >= 2)
                System.out.println(map.get(key));
            //System.out.println(key + " "+ map.get(key));
        }
        return 0;
    }
}
