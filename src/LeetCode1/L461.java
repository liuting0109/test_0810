package LeetCode1;

public class L461 {
    public int hammingDistance(int x, int y) {
        int z = x^y;
        int sum = 0;
        while (z != 0){
            sum ++;
            z &= (z - 1);
        }
        return sum;
        //return Integer.bitCount(x^y);//亦可
    }
}
