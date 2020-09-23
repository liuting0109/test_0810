package domain.test_month9.Sougou;

import java.util.Arrays;

public class Sougou1 {
    public static void main(String[] args) {
        System.out.println(numberofprize(4,4,2));
        System.out.println(numberofprize(9,3,3));
    }
    public static int numberofprize (int a, int b, int c) {
        // write code here
        int res = 0;

        int temp[] ={a,b,c};
        Arrays.sort(temp);
        c = temp[0];
        b = temp[1];
        a = temp[2];

        res = c;
        a -= c;
        b -=c;
        c -=c;

        while (a != 0 ){
            while (b != 0 ){
                b -= 1;
                a -= 1;
                res++;
                if (b < 2){
                    break;
                }
            }

            if (a >= 5){
                res++;
                a -= 4;
            }else {
                break;
            }
        }

        return res;
    }
}
