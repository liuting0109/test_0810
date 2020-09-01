package domain.test;

public class t58_2 {
    /*
    500内找加上a或b都为完全平方数的数 ac
     */
    public static void main(String[] args) {
        System.out.println(question(100, 200));
    }
    public static int question (int a, int b) {
        for (int i = 0; i < 500; i++) {
            int t = (int) Math.sqrt(i + a);
            if ( t * t == i + a){
                int t2 = (int) Math.sqrt(i + b);
                if (t2 * t2 == i + b){
                    return i;
                }
            }
        }
        return 0;
        // write code here
    }

}
