package domain.test;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.*;

public class q1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(CalulateMethodCount(n));
    }
    public static int CalulateMethodCount (int num_money) {
        // write code here

        if (num_money == 1)
            return 1;
        else if (num_money == 2)
            return 2;
        else if (num_money == 3)
            return 4;
        //return (int) Math.pow(2,num_money - 1);
        int res = 1;
        for (int i = 1; i < num_money; i++) {
            res *= 2;
        }
        return res;
    }
}
