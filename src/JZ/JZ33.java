package JZ;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 所有的丑数分为三种类型 2*i,3*i,5*i     其中 i是数组中的元素，一开始只有1
 * 2*1  3*1  5*1
 * 2*2  3*1  5*1
 * 2*2  3*2  5*1
 * 2*3  3*2  5*1
 * 2*3  3*2  5*2
 * 2*4  3*3  5*2
 * 2*5  3*3  5*2
 * 2*5  3*4  5*2
 * 2*6  3*4  5*3
 * 2*8  3*5  5*3
 * 2*8  3*6  5*4
 */

public class JZ33 {
    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(4));
    }
    public static int GetUglyNumber_Solution(int index) {
        if (index <= 0)
            return 0;
        int[] res = new int[index + 1];
        res[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;//初始化三个指向三个潜在成为最小丑数的位置
        for (int i = 1; i < index; i++) {
            res[i] = Math.min(res[p2] * 2, Math.min(res[p3] * 3, res[p5] * 5));
            if (res[i] == res[p2] * 2) p2++;//为了防止重复需要三个if都能够走到
            if (res[i] == res[p3]*3)p3++;
            if (res[i] == res[p5]*5)p5++;
        }
        return res[index - 1];
    }
}
