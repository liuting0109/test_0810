package JZ;

public class JZ7 {
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
}
