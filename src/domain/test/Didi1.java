package domain.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Didi1 {
    public static ArrayList<Integer> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fun(n);
        if (res.size() == 0){
            System.out.println(0);
        } else {
            System.out.println(res.size() / 2);
            Collections.sort(res);
            int count = 1;
            for (Integer i : res) {
                count++;
                System.out.print(i + " ");
                if (count %2 == 1){
                    System.out.println();
                }
            }
        }
    }
    public static ArrayList<Integer> fun(int n){
        int num1 = 0;
        int num2 = 0;
        for (int a = 1; a < 9; a++) {
            for (int c = 0; c < 9; c++) {
                if (c == a) continue;
                for (int b = 0; b < 9; b++) {
                    if (b == a || b == c) continue;
                    num1 = a*100 + b*10 + c;
                    num2 = a*100 + c*10 + c;
                    if ((num1 + num2 == n) && (num1 != num2)){
                        res.add(num1);
                        res.add(num2);
                    }
                }
            }
        }
        return res;
    }
}
