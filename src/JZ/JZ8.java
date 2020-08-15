package JZ;

public class JZ8 {
    /*
一只青蛙一次可以跳上1级台阶，也可以跳上2级。
求该青蛙跳上一个n级的台阶总共有多少种跳法
（先后次序不同算不同的结果）。
 */
    public int JumpFloor(int target) {
        if (target <= 1)
            return target;

        int a = 0;
        int b = 1;
        int c;
        for (int i = 0; i <= target; i++) {//i < target错误
            c = a + b;
            a = b;
            b = c;
        }
        return a;
    }
}
