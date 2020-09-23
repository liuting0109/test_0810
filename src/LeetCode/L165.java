package LeetCode;

/**
 * @Author LT
 * @Date 2020/9/10 15:49
 * @Version 1.0
 * @Description
 */
//比较版本号
public class L165 {
    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "1.1"));
    }
    public static int compareVersion(String version1, String version2) {
        String[] a1 = version1.split("\\.");//需要转义
        String[] a2 = version2.split("\\.");
        for (int n = 0; n < Math.max(a1.length, a2.length); n++) {
            int i =  (n < a1.length ? Integer.valueOf(a1[n]): 0);
            int j =  (n < a2.length ? Integer.valueOf(a2[n]): 0);
            if (i > j) return 1;
            else if (i < j)
                return -1;
        }
        return 0;
    }
}
