package domain.month12;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author LT
 * @Date 2020/12/2 11:25
 * @Version 1.0
 * @Description
 */
public class t122 {
    static {
        System.out.println("hh");
    }
    public static void main(String[] args) {
        Map map = new TreeMap();
        map.put(1, "one");
        map.put(1,"two");
        System.out.println(map.size());
    }
}
