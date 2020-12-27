package LeetCode;

/**
 * @Author LT
 * @Date 2020/12/27 14:39
 * @Version 1.0
 * @Description
 */
public class L461 {
    public int hammingDistance(int x, int y) {
        int temp = x ^ y;
        int count = 0;
        while (temp != 0){
            temp &= (temp - 1);
            count++;
        }
        return count;
        //return Integer.bitCount(x^y);//亦可
    }

}
