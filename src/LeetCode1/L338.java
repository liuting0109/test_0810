package LeetCode1;

public class L338 {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        /*for (int i = 0; i <= num; i++) {
            res[i] = numof1(i);
        }
        return res;*/

         /*奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1。
        偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。
         */
         res[0] = 0;
        for (int i = 1; i <= num; i++) {
            if (i %2 == 1){
                res[i] = res[i -1] +1;
            }else {
                res[i] = res[i/2];
            }
        }
        return res;
    }

    /*public int numof1(int n){
        int count = 0;
        while (n > 0){
            n &= (n-1);
            count++;
        }
        return count;
    }*/
}
