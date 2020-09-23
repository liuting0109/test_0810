package domain.test_month9.BeiKe;

import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/7 15:11
 * @Version 1.0
 * @Description
 */
/*
1
S J J B
 */
public class BeiKe1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        String[][] game = new String[T][4];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 4; j++) {
                game[i][j] = sc.next();
            }
            String res = fun(game[i]);
            System.out.println(res);
        }
    }
    public static String fun(String[] str){
        int left = 0;
        int right = 0;
        if (helper(str[0], str[2])){
            left++;
        }
        if (helper(str[0], str[3])){
            left++;
        }
        if (helper(str[1], str[2])){
            right++;
        }
        if (helper(str[1], str[3])){
            right++;
        }
        //System.out.println(left +" "+ right);
        if (left > right)
            return "left";
        else if (left < right){
            return "right";
        }
        return "same";
    }
    public static boolean helper(String a, String b){
        if (a.equals("S") && b.equals("J")){
            return true;
        }else if (a.equals("S") && b.equals("B")){
            return false;
        }else if (a.equals("S") && b.equals("S")){
            return false;
        }else if (a.equals("J") && b.equals("J")){
            return false;
        }else if (a.equals("J") && b.equals("B")){
            return true;
        }else if (a.equals("J") && b.equals("S")){
            return false;
        }else if (a.equals("B") && b.equals("J")){
            return false;
        }else if (a.equals("B") && b.equals("S")){
            return true;
        }else if (a.equals("B") && b.equals("B")){
            return false;
        }
        return false;
    }
}
