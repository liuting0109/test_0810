package JZ;

public class JZ7 {
    /*
    斐波那契数列，现在要求输入一个整数n，
    请你输出斐波那契数列的第n项（从0开始，第0项为0，
    第1项是1）。n<=39
     */
    public int Fibonacci(int n) {
        if (n <= 1)
            return n;
        int a = 0;
        int b = 1;
        int c;
        for (int i = 0; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return a;
        //return Fibonacci(n -1) + Fibonacci( n - 2);
    }

    public int Fibonacci1(int n) {
        if (n == 0)
            return 0;
       if (n <= 2)
           return 1;
        int a = 1;
        int b = 1;
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

}
