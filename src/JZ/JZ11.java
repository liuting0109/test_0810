package JZ;

public class JZ11 {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0){
            count++;
            n&=(n - 1);
        }
        return count;
    }
}
