package JZ;
/*
求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class JZ31 {
    public static void main(String[] args) {
        int res = NumberOf1Between1AndN_Solution(55);
        //System.out.println(1/10);
        System.out.println(res);
    }
    public static int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += fun(i);
        }
        return count;
    }

    //注意审题，11算2次 有2个1
    private static int fun(int n) {
        int count = 0;
        while (n != 0){
            if (n % 10==1)
                count++;
            n /=10;
        }
        return count;
    }

    //不符合题意
    private static boolean fun1(int n) {
        while (n != 0){
            if (n % 10==1)
                return true;
            n /=10;
        }
        return false;
    }
}

