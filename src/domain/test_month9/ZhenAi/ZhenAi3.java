package domain.test_month9.ZhenAi;

/**
 * @Author LT
 * @Date 2020/9/11 21:11
 * @Version 1.0
 * @Description
 */
public class ZhenAi3 {
    public static void main(String[] args) {
        String str = "3*(5+5)+2*7";
        int res = jiSuan(str);
        System.out.println(res);
    }

    private static int jiSuan(String str) {
        int res = 0;
        res = Integer.valueOf(str);
        return res;
    }
}
