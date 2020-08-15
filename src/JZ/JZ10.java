package JZ;

public class JZ10 {
    /*
    我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
    请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，
    总共有多少种方法？
比如n=3时，2*3的矩形块有3种覆盖方法：
     */
    public int RectCover(int target) {
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
