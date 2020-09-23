package domain.test.YuanFuDao;

import java.util.Scanner;

public class YuanFuDao3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        if (M == 0)
            System.out.println(N - 1);
        System.out.println();
    }
}
