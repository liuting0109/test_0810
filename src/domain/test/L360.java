package domain.test;

import java.util.Scanner;

public class L360 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n =sc.nextInt();
        String[] name = new String[n];
        for (int i = 0; i < n; i++) {
            name[i] = sc.next();
        }
        System.out.println(fun(name));
    }

    private static int fun(String[] name) {
        int count = 0;
        for (int i = 0; i < name.length; i++) {
            if (name[i].length() > 10){
                continue;
            }
            String temp = name[i];
            if (judge(temp))
                count++;
        }
        return count;
    }

    public static boolean judge(String temp){
        for (int i = 0; i < temp.length(); i++) {
            if ((temp.charAt(i) > 'a' && temp.charAt(i) < 'z') ||(temp.charAt(i) > 'A' && temp.charAt(i) < 'Z')){

            }else {
                return false;
            }
        }
        return true;
    }
}
