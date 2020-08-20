package JZ;
/*
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
 */
public class JZ51 {
    public int[] multiply1(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        B[0] = 1;
        //计算下三角连乘
        for (int i = 1; i < len; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }

        int temp = 1;
        //计算上三角
        for (int j = len - 2; j >= 0; j--) {
            temp *= A[j + 1];
            B[j] *= temp;
        }
        return B;
    }
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] f1 = new int[n];
        f1[0] = 1;
        int[] f2 = new int[n];
        f2[n - 1] = 1;
        int[] B = new int[n];
        for (int i = 1; i < n; i++) {
            f1[i] = f1[i - 1] * A[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            f2[i] = f2[i + 1] * A[i + 1];
        }
        for (int i = 0; i < n; i++) {
            B[i] = f1[i] * f2[i];
        }
        return B;
    }
}
