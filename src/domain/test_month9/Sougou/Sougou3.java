package domain.test_month9.Sougou;

public class Sougou3 {
    public static void main(String[] args) {
        System.out.println(getPasswordCount("8"));
    }
    public static long getPasswordCount (String password) {
        // write code here
        int n =password.length();
        double[] num = new double[n];
        for (int i = 0; i < n; i++) {
            num[i] = (double) password.charAt(i);
        }
        //double[] num = new double[n];
        long res = 0;
        if (Integer.valueOf(password) <= 9){
            return Integer.valueOf(password) - 1;
        }
        return res;
    }
}
