package LeetCode;

public class L70 {
    public int climbStairs(int n) {
        /*if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return climbStairs(n - 1) +climbStairs(n - 2);//复杂度过高*/
        if (n <= 2)
            return n;
        int i1 = 1;
        int i2 = 2;
        for (int i = 3; i <= n; i++) {
            int temp = i1 +i2;
            i1 = i2;
            i2 = temp;
        }
        return i2;
    }
}
