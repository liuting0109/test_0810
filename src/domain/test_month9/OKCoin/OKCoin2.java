package domain.test_month9.OKCoin;

/**
 * @Author LT
 * @Date 2020/9/17 14:45
 * @Version 1.0
 * @Description
 */
//判断是否是2的次幂
public class OKCoin2 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(6));
    }
    public static boolean isPowerOfTwo (int n) {
        // write code here
        if (n <= 0)return false;
        if (n == 1)return true;
        while (n != 0){
            if (n == 2)
                return true;
            if (n % 2 != 0)
                return false;
            n  /= 2;
        }
        return true;
    }
}
