package JZ;

public class JZ8 {
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
