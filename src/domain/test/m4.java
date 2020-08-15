package domain.test;

import java.util.Scanner;

public class m4 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n =sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] arr = new int[2*n];
        for (int i = 0; i < 2*n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(fun(arr, a, b));
    }
    public static int fun(int[] arr, int a, int b){
        int sum = 0;
        return sum;
    }
}
