package domain.test;

import java.util.*;

public class m1 {
    static ArrayList<Integer> res = new ArrayList<>();
    static int count = 0;
    public static void main(String[] args) {
        int num = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 2178){
            System.out.println(0);
        }else {
            fun(n);
            System.out.println(count);
            for (Integer i: res){
                System.out.print(i+" ");
                /*if (num % 2== 1)
                    System.out.println();
                num++;*/
            }
            //System.out.println(res);
        }
       // fun(n);
        /*int n = 190;
        System.out.println(reverse(n));*/
        //System.out.println(res);
    }
    public static void fun(int n){
        for (int i = 1; i <= n ;i++){
            int rev = reverse(i);
            if (rev == 4*i){
                count++;
                res.add(i);
                res.add(rev);
            }
        }
    }

    public static int reverse(int n){
        String str = Integer.toString(n);
        StringBuffer sb = new StringBuffer();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return Integer.valueOf(sb.toString());
    }
    /*


import java.util.*;

public class Main {
    static ArrayList<Integer> res = new ArrayList<>();
static int count = 0;
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    if (n < 2178){
        System.out.println(0);
    }else {
        fun(n);
        System.out.println(count);
        for (Integer i: res){
            System.out.print(i+" ");
        }
        //System.out.println(res);
    }
}
public static void fun(int n){
    for (int i = 1; i <= n ;i++){
        int rev = reverse(i);
        if (rev == 4*i){
            count++;
            res.add(i);
            res.add(rev);
        }
    }
}

public static int reverse(int n){
    String str = Integer.toString(n);
    StringBuffer sb = new StringBuffer();
    for (int i = str.length() - 1; i >= 0; i--) {
        sb.append(str.charAt(i));
    }
    return Integer.valueOf(sb.toString());
}
}

     */
}
